package view;

import domain.*;

import java.util.List;

public class OutputView {
    public void printEmptyLine() {
        System.out.println();
    }

    public void printParticipantInquiry() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printResultPrizeInquiry() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printLadderHeightInquiry() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printResult(Participants participants, Ladder ladder, List<Prize> prizes) {
        System.out.println("사다리 결과\n");

        printParticipantsResult(participants.getParticipants());

        printLadderResult(ladder);

        printPrizesResult(prizes);

        printEmptyLine();
    }

    private void printParticipantsResult(List<Participant> participants) {
        for (Participant participant : participants) {
            String name = participant.getParticipantName();
            String blanks = " ".repeat(5 - name.length());
            System.out.print(blanks + name + " ");
        }
        System.out.println();
    }

    private void printLadderResult(Ladder ladder) {
        List<RowLine> rowLines = ladder.getLines();

        for (RowLine rowLine : rowLines) {
            System.out.print("    ");
            printLadderRowResult(rowLine);
            System.out.println();
        }
    }

    private void printLadderRowResult(RowLine rowLine) {
        for (Direction direction : rowLine.getPoints()) {
            printByDirection(direction);
        }
    }

    private void printByDirection(Direction direction) {
        if (direction == Direction.RIGHT) {
            System.out.print("|-----");
            return;
        }

        System.out.print("|     ");
    }

    private void printPrizesResult(List<Prize> prizes) {
        for (Prize prize : prizes) {
            String name = changePrizeToString(prize);
            String blanks = " ".repeat(5 - name.length());
            System.out.print(blanks + name + " ");
        }
        System.out.println();
    }

    public void printParticipantPrizeInquiry() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public void printParticipantPrizeResult(Prize prize) {
        System.out.println("실행 결과");
        System.out.println(changePrizeToString(prize) + "\n");
    }

    public void printParticipantsPrizesResult(Participants participants, GameResult gameResult) {
        System.out.println("실행 결과");
        for (Participant participant : participants.getParticipants()) {
            String name = participant.getParticipantName();
            Prize prize = gameResult.getPrize(participant);
            System.out.println(name + " : " + changePrizeToString(prize));
        }
    }

    private String changePrizeToString(Prize prize) {
        int cost = prize.getCost();
        if (cost == 0) {
            return "꽝";
        }

        return String.valueOf(cost);
    }
}
