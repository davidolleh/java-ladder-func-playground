package domain;

import java.util.List;

public class RowLine {
    private final List<Direction> points;

    public RowLine(List<Direction> points) {
        validateRowLine(points);
        this.points = points;
    }

    public List<Direction> getPoints() {
        return points;
    }

    private void validateRowLine(List<Direction> rowDirections) {
        int rowSize = rowDirections.size();
        int rightCount = 0;

        for (int i = 0; i < rowSize; i++) {
            if (rowDirections.get(i) == Direction.RIGHT) {
                validateRight(i, rowSize, rowDirections);
                rightCount++;
            }

            if (rowDirections.get(i) == Direction.LEFT) {
                validateLeft(rightCount);
                rightCount--;
            }
        }
    }

    private void validateRight(int columnIndex, int rowSize, List<Direction> rowDirections) {
        if (columnIndex == rowSize - 1 || rowDirections.get(columnIndex + 1) != Direction.LEFT) {
            throw new RuntimeException("사다리가 잘못 만들어졌습니다.");
        }
    }

    private void validateLeft(int rightCount) {
        if (rightCount == 0) {
            throw new RuntimeException("사다리가 잘못 만들어졌습니다.");
        }
    }
}
