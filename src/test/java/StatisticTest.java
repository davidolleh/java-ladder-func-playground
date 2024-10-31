import domain.*;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class StatisticTest {
    @ParameterizedTest
    @MethodSource("matchCountWithRank")
    public void 참여자는_사다리를_이동하여_상품과_매치된다(Ladder ladder, List<Person> participants, List<Prize> prizes) {
        Statistic statistic = new Statistic(ladder, participants, prizes);
        Map<Person, Prize> statisticResult = statistic.getParticipantPrize();
        Person s1= participants.get(0);
        Person s2= participants.get(1);
        Person s3= participants.get(2);
        Person s4= participants.get(3);
        Prize p1 = prizes.get(0);
        Prize p2 = prizes.get(1);
        Prize p3 = prizes.get(2);
        Prize p4 = prizes.get(3);

        assertThat(statisticResult.get(s1)).isEqualTo(p3);
        assertThat(statisticResult.get(s2)).isEqualTo(p2);
        assertThat(statisticResult.get(s3)).isEqualTo(p1);
        assertThat(statisticResult.get(s4)).isEqualTo(p4);
    }

    private static Stream<Arguments> matchCountWithRank() {
        return Stream.of(
                Arguments.of(
                        new Ladder(4, 4, new MockRandomLadderGenerator.NormalLadderGenerator()),
                        List.of(
                                new Person("s1"),
                                new Person("s2"),
                                new Person("s3"),
                                new Person("s4")
                        ),
                        List.of(
                                new Prize(0),
                                new Prize(1000),
                                new Prize(2000),
                                new Prize(3000)
                        )
                )
        );
    }
}
