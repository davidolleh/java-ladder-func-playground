import domain.Direction;
import domain.Participant;
import domain.Participants;
import domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class ParticipantTest {
    @Test
    public void 중복된_이름을_가진_참여자는_존재할_수_없다() {
        String name = "SJ";
        Person person1 = new Person(name);
        Person person2 = new Person(name);
        Person person3 = new Person("그리디");

        List<Person> people = List.of(person1, person2, person3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> Participants.fromPeople(people));
    }

    @Test
    public void 참여자는_정해진_라인을따라_이동한다() {
        Person person = new Person("그리디");

        Participant participant = new Participant(person, 0);

        participant.move(Direction.RIGHT);
        participant.move(Direction.RIGHT);

        assertThat(participant.getPosition()).isEqualTo(2);
    }
}
