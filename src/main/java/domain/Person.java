package domain;

public record Person(String name) {
    private static final int MAX_LENGTH = 5;

    public Person {
        validateName(name);
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH || name.isEmpty())
            throw new IllegalArgumentException("사람 이름은 1글자 이상 5글자 이하여야 합니다.");
    }
}
