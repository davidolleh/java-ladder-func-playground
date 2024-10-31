import domain.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class LadderTest {
    @Test
    void 사다리는_라인이_겹치면_안_된다() {
        int lineHeight = 4;
        int ladderWidth = 4;

        Assertions.assertThrows(RuntimeException.class, () -> {
            Ladder ladder = new Ladder(
                    lineHeight,
                    ladderWidth,
                    new MockRandomLadderGenerator.AbnormalLadderGenerator()
            );
        });
    }

    @Test
    void 정상적인_사다리_생성() {
        int lineHeight = 4;
        int ladderWidth = 4;


        Assertions.assertDoesNotThrow(() -> {
            Ladder ladder = new Ladder(
                    lineHeight,
                    ladderWidth,
                    new MockRandomLadderGenerator.NormalLadderGenerator()
            );
        });
    }

}
