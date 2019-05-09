package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class View {

    /* Scanner 변수 */
    private static final Scanner sc = new Scanner(System.in);

    /* String matches에 사용할 알파벳 REGEX 정의 */
    private static final String ALPHABET_REGEX = "^[a-zA-Z]*$";

    /* String matches에 사용할 숫자 REGEX 정의*/
    private static final String NUMBER_REGEX = "[0-9]*$";

    /* 가능한 이름의 최대 길이 저장 */
    private static final int VALID_NAME_LENGTH = 5;

    public static void outputLine(String aString) {
        System.out.println(aString);
    }

    public static void output(String aString) {
        System.out.print(aString);
    }

    public static String[] inputNameOfCar() {
        String[] scannedName;
        do {
            outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            scannedName = sc.nextLine().split(",");                     // ','을 기준으로 나눔
        } while (!isNamesValid(scannedName));
        return scannedName;
    }

    public static boolean isNamesValid(String[] scannedName) {
        int index = 0;
        while (index < scannedName.length && isNameValid(scannedName[index])) {
            index++;                                                                    // 이름이 5보다 크거나, 알파벳 이외의 문자가 있으면
        }

        if(isNameOverlap(scannedName)){
            outputLine("중복된 이름이 있습니다. 다시 입력하세요.");
            return false;
        }
        return true;
    }

    private static boolean isNameValid(String name) {
        if ((name.length() > VALID_NAME_LENGTH) || (!name.matches(ALPHABET_REGEX))) {
            outputLine("잘못 입력하였습니다.(5글자 이하 영문자 이름을 입력하세요)");
            return false;
        }
        return true;
    }

    private static boolean isNameOverlap(String[] scannedName) {
        Set<String> hashSet = new HashSet<>(Arrays.asList(scannedName));
        return scannedName.length != hashSet.size();
    }

    public static int inputNumberOfTry() {
        outputLine("시도할 횟수는 몇회인가요?");
        String scannedNumberOfTry;

        while (true) {
            scannedNumberOfTry = sc.nextLine();

            if (scannedNumberOfTry.matches(NUMBER_REGEX)) {
                return Integer.parseInt(scannedNumberOfTry);        // 입력 받은 수가 올바르면 int로 반환
            }
            outputLine("잘못된 입력입니다. 정수만 입력하세요.");    // 올바른 수가 아니면
        }
    }
}

