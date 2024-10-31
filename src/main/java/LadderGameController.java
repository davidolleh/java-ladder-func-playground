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
        if (participants.size() != prizes.size()) {
            throw new IllegalArgumentException("The number of participants does not match the number of prizes.");
        }

        int height = readLadderHeight();

        Ladder ladder = new Ladder(height, participants.size(), new RandomLadderGeneratorImpl());
//        Map<Person, Prize> participantPrizes = Statistic.statisticResult(ladder, participants, prizes);

        outputView.printResult(participants, ladder, prizes);
        outputView.printEmptyLine();

        Statistic statistic = new Statistic(ladder, participants, prizes);


        while(true) {
            String name = readParticipantName();

            if (name.equals("all")) {
                break;
            }

            Person person = new Person(name);
            checkParticipantValidation(participants, person);
            outputView.printParticipantPrizeResult(statistic.getParticipantPrize(person));
        }


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

    private void checkParticipantValidation(List<Person> participants, Person person) {
        if (!participants.contains(person)) {
            throw new IllegalArgumentException("참여자가 아닙니다.");
        }
    }
}
