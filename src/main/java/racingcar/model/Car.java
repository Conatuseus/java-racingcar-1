package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

import java.util.List;
import java.util.Objects;

public class Car {
    private static final int POSSIBLE_MOVE = 4;
    private static final int VALID_NAME_LENGTH = 5;
    /* String matches에 사용할 알파벳 REGEX 정의 */
    private static final String ALPHABET_REGEX = "^[a-zA-Z]*$";
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (!this.isValidName(name)) {
            throw new IllegalArgumentException("이름이 잘 못 되었습니다.");
        }
        this.name = name.trim();
    }

    /* 테스트를 위한 생성자 */
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean isValidName(String name) {
        return this.isNameNotNull(name) && this.isNameNotBlank(name.trim())
                && this.isNameConsistOfAlphabet(name.trim()) && this.isNameRightLength(name.trim());
    }

    private boolean isNameNotNull(String name) {
        return name != null;
    }

    private boolean isNameNotBlank(String name) {
        return !StringUtils.isBlank(name);
    }

    private boolean isNameRightLength(String name) {
        return name.length() <= VALID_NAME_LENGTH;
    }

    private boolean isNameConsistOfAlphabet(String name) {
        return name.matches(ALPHABET_REGEX);
    }

    public void move(int randomNumber) {
        if (randomNumber >= POSSIBLE_MOVE) {
            position++;
        }
    }

    public void addWinners(List<String> winnerList, int maxPosition) {
        if (this.getPosition() == maxPosition) {
            winnerList.add(this.getName());
        }
    }

    public int getMaxPosition(int maxPosition) {
        return Integer.max(this.position, maxPosition);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" : ");
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return (position == car.position) &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
