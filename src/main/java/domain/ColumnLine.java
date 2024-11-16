package domain;

import java.util.List;

public class ColumnLine {
    private final List<Direction> points;

    public ColumnLine(List<Direction> points) {
        this.points = points;
    }

    public List<Direction> getPoints() {
        return points;
    }

    public int getLineHeight() {
        return points.size();
    }
}
