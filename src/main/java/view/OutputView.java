package view;

import domain.*;

import java.util.List;

public class OutputView {

    public void printParticipantInquiry() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printResultPrizeInquiry() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printLadderHeightInquiry() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadderResult(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        int ladderWidth = lines.size();
        int lineHeight = lines.get(0).getPoints().size();

        for (int i = 0; i < lineHeight; i++) {
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
}
