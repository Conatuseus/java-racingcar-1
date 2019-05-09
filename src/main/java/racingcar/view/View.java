package racingcar.view;

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
        while (true) {
            outputLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            scannedName = sc.nextLine().split(",");                     // ','을 기준으로 나눔

            if (isNamesValid(scannedName)) {
                return scannedName;                                            // 옳은 입력이면 자동차 이름 배열 반환
            }
            outputLine("잘못 입력하였습니다.(5글자 이하 영문자, 중복되지 않는 이름을 입력하세요)");
        }
    }

    public static boolean isNamesValid(String[] scannedName) {
        for (String name : scannedName) {
            if ((name.length() > VALID_NAME_LENGTH) || (!name.matches(ALPHABET_REGEX))) {
                return false;                   // 이름이 5보다 크거나, 알파벳 이외의 문자가 있으면
            }
        }
        return !isNameOverlap(scannedName);        // 중복된 이름이 있는지 없는지 반환
    }

    private static boolean isNameOverlap(String[] scannedName) {
        Set<String> hashSet = new HashSet<>();
        for (String name : scannedName) {
            if (hashSet.contains(name)) {
                return true;                // 해쉬셋에 이미 있는 이름이면 true 반환
            }
            hashSet.add(name);              // 해쉬셋에 없는 이름이면 해쉬셋에 추가
        }
        return false;           // 중복된 이름이 없으면
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

