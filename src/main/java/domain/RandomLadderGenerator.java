package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomLadderGenerator {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private static final int RANDOM_BOUND = 10;

    public List<Line> generateLadder(int lineHeight, int ladderWidth) {
        List<List<Connection>> columnRowConnections = generateLadderConnection(lineHeight, ladderWidth);

        return IntStream.range(0, ladderWidth)
                .mapToObj(i -> generateLineByConnections(i, lineHeight, ladderWidth, columnRowConnections))
                .toList();
    }


    private List<List<Connection>> generateLadderConnection(int lineHeight, int ladderWidth) {
        List<List<Connection>> rowColumnConnections = new ArrayList<>();

        for (int i = 0; i < lineHeight; i++) {
            List<Connection> rowConnections = generateRowConnections(ladderWidth);
            rowColumnConnections.add(rowConnections);
        }

        int ladderConnectionWidth = ladderWidth - 1;


        return rotate2DConnection(ladderConnectionWidth, rowColumnConnections);
    }

    private List<Connection> generateRowConnections(int ladderWidth) {
        List<Connection> rowConnections = new ArrayList<>();

        int ladderConnectionCount = ladderWidth - 1;
        for (int i = 0; i < ladderConnectionCount; i++) {
            Connection isConnected = generateSpotToSpotConnection(i, rowConnections);
            rowConnections.add(isConnected);
        }

        return rowConnections;
    }

    private Connection generateSpotToSpotConnection(int lineIndex, List<Connection> rowSpotsConnection) {
        if (lineIndex != 0 && rowSpotsConnection.get(lineIndex - 1) == Connection.CONNECTED)
            return Connection.UNCONNECTED;

        int randomValue = random.nextInt(RANDOM_BOUND);

        if (randomValue < 5)
            return Connection.CONNECTED;

        return Connection.UNCONNECTED;
    }

    private Line generateLineByConnections(int lineIndex, int lineHeight, int ladderWidth, List<List<Connection>> columnRowConnections) {
        if (lineIndex == 0) {
            List<Connection> lineRightConnections = columnRowConnections.get(0);
            return generateFirstLine(lineRightConnections);
        }

        if (lineIndex == ladderWidth -1) {
            List<Connection> lineLeftConnections = columnRowConnections.get(lineIndex - 1);
            return generateLastLine(lineLeftConnections);
        }

        List<Connection> lineLeftConnections = columnRowConnections.get(lineIndex - 1);
        List<Connection> lineRightConnections = columnRowConnections.get(lineIndex);
        return generateMiddlesLine(lineHeight, lineLeftConnections, lineRightConnections);
    }

    private Line generateFirstLine(List<Connection> lineRightConnections) {
        List<Direction> lineDirections = lineRightConnections.stream().map(c -> {
            if (c == Connection.CONNECTED)
                return Direction.RIGHT;

            return Direction.DOWN;
        }).toList();

        return new Line(lineDirections);
    }

    private Line generateLastLine(List<Connection> lineLeftConnections) {
        List<Direction> lineDirections = lineLeftConnections.stream().map(c -> {
            if (c == Connection.CONNECTED)
                return Direction.LEFT;

            return Direction.DOWN;
        }).toList();

        return new Line(lineDirections);
    }

    private Line generateMiddlesLine(int lineHeight, List<Connection> lineLeftConnections, List<Connection> lineRightConnections) {
        List<Direction> lineDirections = new ArrayList<>();

        for (int j = 0; j < lineHeight; j++) {

            if (lineLeftConnections.get(j) == Connection.UNCONNECTED && lineRightConnections.get(j) == Connection.UNCONNECTED) {
                lineDirections.add(Direction.DOWN);
                continue;
            }

            if (lineLeftConnections.get(j) == Connection.CONNECTED) {
                lineDirections.add(Direction.LEFT);
                continue;
            }

            lineDirections.add(Direction.RIGHT);
        }
        return new Line(lineDirections);
    }

    private List<List<Connection>> rotate2DConnection(int rowSize, List<List<Connection>> rowColumnConnections) {
        List<List<Connection>> columnRowConnections = new ArrayList<>();
        for (int j = 0; j < rowSize; j++) {
            List<Connection> columnConnections = getColumnConnections(j, rowColumnConnections);
            columnRowConnections.add(columnConnections);
        }

        return columnRowConnections;
    }

    private List<Connection> getColumnConnections(int columnIndex, List<List<Connection>> ladderConnection) {
        return ladderConnection.stream()
                .map(l -> l.get(columnIndex))
                .toList();
    }
}
