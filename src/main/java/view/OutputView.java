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

    public void printResult(List<Person> participants, Ladder ladder, List<Prize> prizes) {
        System.out.println("사다리 결과");

        printParticipantsResult(participants);

        printLadderResult(ladder);

        printPrizesResult(prizes);
    }

    private void printParticipantsResult(List<Person> participants) {
        for (Person participant : participants) {
            String name = participant.getName();
            String blanks = " ".repeat(5 - name.length());
            System.out.print(blanks + name + " ");
        }
        System.out.println();
    }

    private void printLadderResult(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        int ladderWidth = ladder.getLadderWidth();
        int lineHeight = ladder.getLineHeight();

        for (int i = 0; i < lineHeight; i++) {
            System.out.print("    ");
            for (int j = 0; j < ladderWidth; j++) {
                Direction direction = lines.get(j).getPoints().get(i);
                if (direction == Direction.RIGHT) {
                    System.out.print("|-----");
                } else {
                    System.out.print("|     ");
                }
            }
            System.out.println();
        }
    }

    private void printPrizesResult(List<Prize> prizes) {
        for (Prize prize : prizes) {
            String name = prize.costToString();
            String blanks = " ".repeat(5 - name.length());
            System.out.print(blanks + name + " ");
        }
        System.out.println();
    }

    public void printPersonPrizeResult() {

    }
}
