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
        List<Person> participants = readParticipants();
        List<Prize> prizes = readPrizes();

        checkPrizeCountValidation(participants.size(), prizes.size());

        int height = readLadderHeight();


        LadderFactory ladderGenerator = new LadderFactory(height, participants.size()); //ladderFactory
        Ladder ladder = ladderGenerator.newInstance();

        outputView.printResult(participants, ladder, prizes);

        Statistic statistic = new Statistic(ladder, participants, prizes);

        printSpecificParticipantResult(statistic, participants);

        outputView.printParticipantsPrizesResult(statistic.getParticipantPrize(), participants);
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

    private void printSpecificParticipantResult(Statistic statistic, List<Person> participants) {
        while (true) {
            String name = readParticipantName();

            if (name.equals("all")) {
                break;
            }

            Person person = new Person(name);
            checkParticipantValidation(participants, person);
            outputView.printParticipantPrizeResult(statistic.getParticipantPrize(person));
        }
    }

    private void checkPrizeCountValidation(int participantCount, int prizeCount) {
        if (participantCount != prizeCount) {
            throw new IllegalArgumentException("The number of participants does not match the number of prizes.");
        }
    }

    private void checkParticipantValidation(List<Person> participants, Person person) {
        if (!participants.contains(person)) {
            throw new IllegalArgumentException("참여자가 아닙니다.");
        }
    }
}
