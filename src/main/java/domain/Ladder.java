package domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        checkLadderValidation(lines);
        this.lines = lines;

    }

    public List<Line> getLines() {
        return lines;
    }


    private void checkLadderValidation(List<Line> lines) {
        // TODO:: 정리하기
        int lineHeight = lines.get(0).getPoints().size();

        for (int i = 0; i < lineHeight; i++) {
            checkRowValidation(i, lines);
        }
    }

    private int getLadderHeight() {
        return lines.size();
    }

    private void checkRowValidation(int rowIndex, List<Line> lines) {
        List<Direction> rowDirections = lines.stream()
                .map(l -> l.getPoints().get(rowIndex))
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
