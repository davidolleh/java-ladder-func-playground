import domain.Direction;
import domain.RowLine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class RowLineTest {
    @Test
    public void 라인의_연결성은_겹치면_안된다() {
        List<Direction> directions1 = List.of(Direction.DOWN, Direction.RIGHT, Direction.RIGHT, Direction.LEFT);
        List<Direction> directions2 = List.of(Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.DOWN);

        Assertions.assertThrows(RuntimeException.class, () -> new RowLine(directions1));
        Assertions.assertDoesNotThrow(() -> new RowLine(directions2));
    }
}
