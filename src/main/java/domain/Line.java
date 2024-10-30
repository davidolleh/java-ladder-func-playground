package domain;

import java.util.List;

public class Line {
    private final List<Direction> points;

    public Line(List<Direction> points) {
        this.points = points;
    }

    public List<Direction> getPoints() {
        return points;
    }
}
