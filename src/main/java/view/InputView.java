package view;

import domain.Person;
import domain.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<Person> readParticipants() {
        String[] participants = scanner.nextLine().split(",");

        return Arrays.stream(participants)
                .map(Person::new)
                .toList();
    }

    public List<Prize> readPrizeResults() {
        String[] prizes = scanner.nextLine().split(",");

        return Arrays.stream(prizes)
                .map(p -> {
                    if (p.equals("꽝"))
                        return new Prize(0);

                    return new Prize(Integer.parseInt(p));
                })
                .toList();


    }

    public int readLadderHeight() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String readPersonName() {
        return scanner.nextLine();
    }
}
