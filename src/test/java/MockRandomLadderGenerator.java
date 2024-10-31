import domain.Direction;
import domain.Line;
import domain.RandomLadderGenerator;

import java.util.List;

public class MockRandomLadderGenerator {
    public static class AbnormalLadderGenerator implements RandomLadderGenerator {
        @Override
        public List<Line> generateLadder(int lineHeight, int ladderWidth) {
            return List.of(
                    new Line(
                            List.of(
                                    Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN
                            )
                    ),
                    new Line(
                            List.of(
                                    Direction.LEFT, Direction.RIGHT, Direction.RIGHT, Direction.DOWN
                            )
                    ),
                    new Line(
                            List.of(
                                    Direction.DOWN, Direction.LEFT, Direction.LEFT, Direction.RIGHT
                            )
                    ),
                    new Line(
                            List.of(
                                    Direction.DOWN, Direction.DOWN, Direction.LEFT, Direction.LEFT
                            )
                    )
            );
        }
    }

    public static class NormalLadderGenerator implements RandomLadderGenerator {
        @Override
        public List<Line> generateLadder(int lineHeight, int ladderWidth) {
            return List.of(
                    new Line(
                            List.of(
                                    Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN
                            )
                    ),
                    new Line(
                            List.of(
                                    Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.DOWN
                            )
                    ),
                    new Line(
                            List.of(
                                    Direction.DOWN, Direction.LEFT, Direction.RIGHT, Direction.RIGHT
                            )
                    ),
                    new Line(
                            List.of(
                                    Direction.DOWN, Direction.DOWN, Direction.LEFT, Direction.LEFT
                            )
                    )
            );
        }
    }

}
