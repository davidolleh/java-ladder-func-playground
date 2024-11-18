package domain;

import java.util.Map;

public class GameResult {
    private final Map<Participant, Prize> gameResult;

    public GameResult(Map<Participant, Prize> gameResult) {
        this.gameResult = gameResult;
    }

    public Prize getPrize(Participant participant) {
        return gameResult.get(participant);
    }
}
