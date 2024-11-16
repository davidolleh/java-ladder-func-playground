package domain;

import java.util.List;

public class Ladder {
    private final List<ColumnLine> columnLines;

    public Ladder(List<ColumnLine> columnLines) {
        checkLadderValidation(columnLines);
        this.columnLines = columnLines;
    }

    public List<ColumnLine> getLines() {
        return columnLines;
    }


    private void checkLadderValidation(List<ColumnLine> columnLines) {
        // TODO:: 정리하기
        int lineHeight = columnLines.get(0).getPoints().size();

        for (int i = 0; i < lineHeight; i++) {
            int columnIndex = i;
            List<Direction> rowDirections = columnLines.stream()
                    .map(l -> l.getRowDirection(columnIndex))
                    .toList();

            checkRowValidation(rowDirections);
        }
    }

    private void checkRowValidation(List<Direction> rowDirections) {
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
