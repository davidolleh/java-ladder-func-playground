package domain;

import java.util.Objects;

public class Participant {
    private final Person person;
    private int position;

    public Participant(Person person, int position) {
        this.person = person;
        this.position = position;
    }

    public void move(Direction direction) {
        position = position + direction.offset;
    }

    public Person getPerson() {
        return person;
    }

    public String getParticipantName() {
        return person.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(person.getName(), that.person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(person.getName());
    }
}
