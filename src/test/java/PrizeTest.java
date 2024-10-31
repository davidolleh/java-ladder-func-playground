import domain.Prize;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class PrizeTest {
    @Test
    public void vo_테스트() {
        int cost1 = 1000;
        int cost2 = 2000;
        Prize prize1 = new Prize(cost1);
        Prize prize2 = new Prize(cost1);
        Prize prize3 = new Prize(cost2);

        assertThat(prize1.equals(prize2)).isTrue();
        assertThat(prize1.equals(prize3)).isFalse();
    }
}
