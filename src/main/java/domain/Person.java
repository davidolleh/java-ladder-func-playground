package domain;

public class Person {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Person(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH || name.isEmpty())
            throw new IllegalArgumentException("사람 이름은 1글자 이상 5글자 이하여야 합니다.");
    }

    public String getName() {
        return name;
    }
}
