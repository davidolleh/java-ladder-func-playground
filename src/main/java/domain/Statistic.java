package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private final Map<Person, Prize> participantsPrizes;

    public Statistic(Ladder ladder, List<Person> participants, List<Prize> prizes) {
        this.participantsPrizes = statisticResult(ladder, participants, prizes);
    }

    public Map<Person, Prize> getParticipantPrize() {
        return participantsPrizes;
    }

    public Prize getParticipantPrize(Person person) {
        return participantsPrizes.get(person);
    }

    private Map<Person, Prize> statisticResult(Ladder ladder, List<Person> participants, List<Prize> prizes) {
        Map<Person, Prize> participantsPrizes = new HashMap<>();
        int height = ladder.getLineHeight();

        for (int i = 0; i < participants.size(); i++) {
            int finalParticipantColumnIndex = getFinalColumnLocation(height, ladder, i);
            participantsPrizes.put(participants.get(i), prizes.get(finalParticipantColumnIndex));
        }

        return participantsPrizes;
    }

    private int getFinalColumnLocation(int height, Ladder ladder, int columnIndex) {
        for (int j = 0; j < height; j++) {
            Direction direction = ladder.getLines().get(columnIndex).getPoints().get(j);
            columnIndex = changeColumnIndexByDirection(direction, columnIndex);
        }

        return columnIndex;
    }

    private int changeColumnIndexByDirection(Direction direction, int columnIndex) {
        if (direction == Direction.RIGHT)
            return ++columnIndex;

        if (direction == Direction.LEFT)
            return --columnIndex;

        return columnIndex;
    }
}
