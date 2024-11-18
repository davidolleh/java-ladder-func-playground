package domain;

public enum Direction {
    LEFT(-1), RIGHT(1), DOWN(0);

    final int offset;

    Direction(int offset) {
        this.offset = offset;
    }
}
