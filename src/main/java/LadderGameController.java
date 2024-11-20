import domain.*;
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
        List<Person> people = readParticipants();
        List<Prize> prizes = readPrizes();

        validateInputsCount(people.size(), prizes.size());

        int height = readLadderHeight();
        int width = people.size();

        LadderFactory ladderGenerator = new RandomLadderFactory(height, width);
        Ladder ladder = ladderGenerator.newInstance();

        Participants participants = Participants.fromPeople(people);
        LadderGame ladderGame = new LadderGame(participants, ladder, prizes);

        outputView.printResult(ladderGame.getParticipants(), ladderGame.getLadder(), ladderGame.getPrizes());

        ladderGame.start();

        GameResult gameResult = ladderGame.getParticipantsPrizes();

        printSpecificParticipantResult(ladderGame.getParticipants(), gameResult);

        outputView.printParticipantsPrizesResult(ladderGame.getParticipants(), gameResult);
    }

    private List<Person> readParticipants() {
        outputView.printParticipantInquiry();
        List<Person> participants = inputView.readParticipants();
        outputView.printEmptyLine();

        return participants;
    }

    private List<Prize> readPrizes() {
        outputView.printResultPrizeInquiry();
        List<Prize> prizes = inputView.readPrizeResults();
        outputView.printEmptyLine();

        return prizes;
    }

    private int readLadderHeight() {
        outputView.printLadderHeightInquiry();
        int height = inputView.readLadderHeight();
        outputView.printEmptyLine();

        return height;
    }

    private String readParticipantName() {
        outputView.printParticipantPrizeInquiry();
        String name = inputView.readPersonName();
        outputView.printEmptyLine();

        return name;
    }

    private void printSpecificParticipantResult(Participants participants, GameResult gameResult) {
        while (true) {
            String name = readParticipantName();

            if (name.equals("all")) {
                break;
            }

            Person person = new Person(name);
            Participant participant = participants.getParticipantByName(person);
            outputView.printParticipantPrizeResult(gameResult.getPrize(participant));
        }
    }

    private void validateInputsCount(int participantCount, int prizeCount) {
        if (participantCount != prizeCount) {
            throw new IllegalArgumentException("The number of participants does not match the number of prizes.");
        }
    }
}
