package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Participants participants;
    private final Ladder ladder;
    private final List<Prize> prizes;
    private GameState gameState;
    private Map<Integer, List<Integer>> result;

    public LadderGame(Participants participants, Ladder ladder, List<Prize> prizes) {
        this.participants = participants;
        this.ladder = ladder;
        this.prizes = prizes;
        this.gameState = GameState.READY;
    }

    public void start() {
        gameState = GameState.PROGRESS;

        Map<Integer, List<Integer>> gameResult = new HashMap<>();

        int participantsCount = participants.getParticipantsCount();

        for (int i = 0; i < participantsCount; i++) {
            Participant participant = participants.getParticipantByIndex(i);
            Integer startPosition = participant.getPosition();
            List<Integer> participantPositions = moveParticipant(participant);
            gameResult.put(startPosition, participantPositions);
        }

        result = gameResult;

        gameState = GameState.FINISH;
    }

    private List<Integer> moveParticipant(Participant participant) {
        List<Integer> participantPositions = new ArrayList<>();

        for (RowLine rowLine : ladder.getLines()) {
            int currentPosition = participant.getPosition();
            Direction direction = rowLine.getPositionDirection(currentPosition);

            participant.move(direction);

            participantPositions.add(participant.getPosition());
        }

        return participantPositions;
    }

    public GameResult getParticipantsPrizes() {
        if (gameState != GameState.FINISH) {
            throw new RuntimeException("게임이 진행중입니다!");
        }

        Map<Participant, Prize> participantsPrizes = new HashMap<>();

        for (Integer startPosition : result.keySet()) {
            List<Integer> positions = result.get(startPosition);
            Integer lastPosition = positions.get(positions.size() - 1);

            participantsPrizes.put(participants.getParticipantByIndex(startPosition), prizes.get(lastPosition));
        }

        return new GameResult(participantsPrizes);
    }

    public Participants getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
