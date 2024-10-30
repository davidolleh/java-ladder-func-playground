import view.InputView;
import view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(
                new InputView(),
                new OutputView()
        );

        ladderGameController.ladderGame();
    }
}
