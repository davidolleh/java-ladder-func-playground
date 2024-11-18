package domain;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public record Participants(List<Participant> participants) {
    public Participants {
        validateParticipants(participants);
    }

    public static Participants fromPeople(List<Person> people) {
        List<Participant> participants = IntStream.range(0, people.size())
                .mapToObj(i -> new Participant(people.get(i), i))
                .toList();

        return new Participants(participants);
    }

    private void validateParticipants(List<Participant> participants) {
        int participantsCount = participants.size();

        Set<Participant> deduplicateParticipants = Set.copyOf(participants);
        int deduplicateParticipantsCount = deduplicateParticipants.size();

        if (participantsCount != deduplicateParticipantsCount) {
            throw new IllegalArgumentException("중복된 이름의 참여자는 참여할 수 없습니다.");
        }
    }

    public int getParticipantsCount() {
        return participants.size();
    }

    public Participant getParticipantByIndex(int index) {
        return participants.get(index);
    }

    public Participant getParticipantByName(Person person) {
        return participants.stream()
                .filter(participant -> participant.getParticipantName().equals(person.name()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
