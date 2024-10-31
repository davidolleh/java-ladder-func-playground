import domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class PersonTest {
    @Test
    public void 사람_이름은_1자_이상_5자_이하_여야_한다() {
        String name1 = "Seung";
        String name2 = "";
        String name3 = "SeungJ";

        Assertions.assertDoesNotThrow(() -> new Person(name1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person(name2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person(name3));
    }
}
