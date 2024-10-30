import domain.Ladder;
import domain.Person;
import domain.Prize;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void ladderGame() {
        outputView.printParticipantInquiry();
        List<Person> participants = inputView.readParticipants();

        outputView.printResultPrizeInquiry();
        List<Prize> prizes = inputView.readPrizeResults();

        if (participants.size() != prizes.size()) {
            throw new IllegalArgumentException("The number of participants does not match the number of prizes.");
        }

        outputView.printLadderHeightInquiry();
        int height = inputView.readLadderHeight();

        Ladder ladder = new Ladder(height, participants.size());

        outputView.printLadderResult(ladder);

    }
}
