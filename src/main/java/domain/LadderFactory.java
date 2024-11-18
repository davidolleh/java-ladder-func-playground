package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class LadderFactory {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private static final int RANDOM_BOUND = 10;

    private final int lineHeight;
    private final int ladderWidth;

    public LadderFactory(int height, int width) {
        this.lineHeight = height;
        this.ladderWidth = width;
    }

    public Ladder newInstance() {
        List<List<Connection>> columnRowConnections = generateLadderConnection(lineHeight, ladderWidth);

        List<RowLine> rowLines = IntStream.range(0, lineHeight)
                .mapToObj(i -> generateRowLineByConnections(columnRowConnections.get(i)))
                .toList();

        return new Ladder(rowLines);
    }

    private List<List<Connection>> generateLadderConnection(int lineHeight, int ladderWidth) {
        List<List<Connection>> rowColumnConnections = new ArrayList<>();

        for (int i = 0; i < lineHeight; i++) {
            List<Connection> rowConnections = generateRowConnections(ladderWidth);
            rowColumnConnections.add(rowConnections);
        }

        return rowColumnConnections;
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

    private RowLine generateRowLineByConnections(List<Connection> rowConnections) {
        List<Direction> directions = new ArrayList<>();

        for (int i = 0; i < ladderWidth; i++) {
            if (i == 0) {
                Direction direction = getFirstLineDirection(rowConnections.get(i));
                directions.add(direction);
                continue;
            }

            if (i == ladderWidth - 1) {
                Direction direction = getLastLineDirection(rowConnections.get(i - 1));
                directions.add(direction);
                continue;
            }

            Direction direction = getMiddleLineDirection(rowConnections.get(i - 1), rowConnections.get(i));
            directions.add(direction);
        }

        return new RowLine(directions);
    }

    private Direction getFirstLineDirection(Connection connection) {
        if (connection == Connection.CONNECTED) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private Direction getLastLineDirection(Connection connection) {
        if (connection == Connection.CONNECTED) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private Direction getMiddleLineDirection(Connection currentConnection, Connection nextConnection) {
        if (currentConnection == Connection.CONNECTED) {
            return Direction.LEFT;
        }

        if (nextConnection == Connection.CONNECTED) {
            return Direction.RIGHT;
        }

        return Direction.DOWN;
    }
}
