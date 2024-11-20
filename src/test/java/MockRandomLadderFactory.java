import domain.Direction;
import domain.Ladder;
import domain.LadderFactory;
import domain.RowLine;

import java.util.List;

public class MockRandomLadderFactory {
    public static class NormalLadderFactory implements LadderFactory {
        @Override
        public Ladder newInstance() {
            List<Direction> directions1 = List.of(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT);
            List<Direction> directions2 = List.of(Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.DOWN);
            List<Direction> directions3 = List.of(Direction.DOWN, Direction.RIGHT, Direction.LEFT, Direction.DOWN);
            List<Direction> directions4 = List.of(Direction.DOWN, Direction.DOWN, Direction.RIGHT, Direction.LEFT);

            List<RowLine> rowLines = List.of(
                    new RowLine(directions1),
                    new RowLine(directions2),
                    new RowLine(directions3),
                    new RowLine(directions4)
            );

            return new Ladder(rowLines);
        }
    }

    public static class AbnormalLadderFactory implements LadderFactory {
        @Override
        public Ladder newInstance() {
            List<Direction> directions1 = List.of(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT);
            List<Direction> directions2 = List.of(Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.DOWN);
            List<Direction> directions3 = List.of(Direction.DOWN, Direction.RIGHT, Direction.RIGHT, Direction.LEFT);
            List<Direction> directions4 = List.of(Direction.DOWN, Direction.DOWN, Direction.RIGHT, Direction.LEFT);


            List<RowLine> rowLines = List.of(
                    new RowLine(directions1),
                    new RowLine(directions2),
                    new RowLine(directions3),
                    new RowLine(directions4)

            );

            return new Ladder(rowLines);
        }
    }
}
