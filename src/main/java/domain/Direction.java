package domain;

public enum Direction {
    LEFT(-1), RIGHT(1), DOWN(0);

    int offset;

    Direction(int offset) {
        this.offset = offset;
    }
}
