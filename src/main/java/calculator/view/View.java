package calculator.view;

import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] input() {
        String[] values;
        do {
            System.out.println("계산할 수식을 입력해 주세요 : ");
            values = scanner.nextLine().split(" ");
        } while (!InputValidator.isValid(values));
        return values;
    }
}
