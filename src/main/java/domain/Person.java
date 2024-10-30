package domain;

import java.util.Objects;

public class Person {
    private final String name;
    private static final int MAX_LENGTH = 5;

    public Person(String name) {
        nameValidation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void nameValidation(String name) {
        if (name.length() > MAX_LENGTH || name.isEmpty())
            throw new IllegalArgumentException("사람 이름은 1글자 이상 5글자 이하여야 합니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
