import domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class LadderGameTest {
    @ParameterizedTest
    @MethodSource("methodSourceTestArguments")
    public void 참여자들은_라인_따라_이동해_상품과_최종적으로_연결을_맺는다(Participants participants, Ladder ladder, List<Prize> prizes) {
        LadderGame game = new LadderGame(participants, ladder, prizes);
        game.start();

        GameResult gameResult = game.getParticipantsPrizes();

        assertThat(gameResult.getPrize(participants.getParticipantByIndex(0))).isEqualTo(prizes.get(0));
        assertThat(gameResult.getPrize(participants.getParticipantByIndex(1))).isEqualTo(prizes.get(3));
        assertThat(gameResult.getPrize(participants.getParticipantByIndex(2))).isEqualTo(prizes.get(2));
        assertThat(gameResult.getPrize(participants.getParticipantByIndex(3))).isEqualTo(prizes.get(1));
    }

    @ParameterizedTest
    @MethodSource("methodSourceTestArguments")
    public void 게임이_완료되어야_최종_결과_학인_가능하다(Participants participants, Ladder ladder, List<Prize> prizes) {
        LadderGame game = new LadderGame(participants, ladder, prizes);

        Assertions.assertThrows(RuntimeException.class, game::getParticipantsPrizes);
    }

    private static Stream<Arguments> methodSourceTestArguments() {
        Person person1 = new Person("프론트");
        Person person2 = new Person("백엔드");
        Person person3 = new Person("데브옵스");
        Person person4 = new Person("그리디");

        List<Person> people = List.of(person1, person2, person3, person4);

        LadderFactory ladderFactory = new MockRandomLadderFactory.NormalLadderFactory();
        Ladder ladder = ladderFactory.newInstance();

        List<Prize> prizes = List.of(
                new Prize(0),
                new Prize(1000),
                new Prize(2000),
                new Prize(3000)
        );

        return Stream.of(
                Arguments.of(Participants.fromPeople(people), ladder, prizes)
        );
    }
}
