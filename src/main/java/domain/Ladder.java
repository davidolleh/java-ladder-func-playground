package domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final RandomLadderGeneratorImpl randomLadderGenerator = new RandomLadderGeneratorImpl();

    public Ladder(int lineHeight, int ladderWidth) {
        List<Line> lines = randomLadderGenerator.generateLadder(lineHeight, ladderWidth);
        checkLadderValidation(lineHeight, lines);
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    private void checkLadderValidation(int lineHeight, List<Line> lines) {
        for (int i = 0; i < lineHeight; i++) {
            checkRowValidation(i, lines);
        }
    }

    private void checkRowValidation(int columnIndex, List<Line> lines) {
        List<Direction> rowDirections = lines.stream()
                .map(l -> l.getPoints().get(columnIndex))
                .toList();

        int rowSize = rowDirections.size();
        int rightCount = 0;

        for (int i = 0; i < rowSize; i++) {
            if (rowDirections.get(i) == Direction.RIGHT) {
                checkRightValidation(i, rowSize, rowDirections);
                rightCount++;
            }

            if (rowDirections.get(i) == Direction.LEFT) {
                checkLeftValidation(rightCount);
                rightCount--;
            }
        }
    }

    private void checkRightValidation(int columnIndex, int rowSize, List<Direction> rowDirections) {
        if (columnIndex == rowSize - 1 || rowDirections.get(columnIndex + 1) != Direction.LEFT) {
            throw new RuntimeException("사다리가 잘못 만들어졌습니다.");
        }
    }

    private void checkLeftValidation(int rightCount) {
        if (rightCount == 0) {
            throw new RuntimeException("사다리가 잘못 만들어졌습니다.");
        }
    }
}
