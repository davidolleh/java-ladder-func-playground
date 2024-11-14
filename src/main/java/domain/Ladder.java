package domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final int ladderWidth;
    private final int lineHeight;
    private final RandomLadderGenerator randomLadderGenerator;


    public Ladder(int lineHeight, int ladderWidth, RandomLadderGenerator randomLadderGenerator) {
        this.randomLadderGenerator = randomLadderGenerator;
        this.ladderWidth = ladderWidth;
        this.lineHeight = lineHeight;

        List<Line> lines = this.randomLadderGenerator.generateLadder(lineHeight, ladderWidth);
        checkLadderValidation(lines);
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }

    public int getLineHeight() {
        return lineHeight;
    }

    private void checkLadderValidation(List<Line> lines) {
        for (int i = 0; i < lineHeight; i++) {
            checkRowValidation(i, lines);
        }
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
