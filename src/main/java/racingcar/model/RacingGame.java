package racingcar.model;

import java.util.*;

public class RacingGame {
    private static final int START_POSITION = 0;
    private List<Car> cars = new ArrayList<>();

    public RacingGame(String[] carNames) {
        if (this.isOverlap(carNames)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    /* 테스트를 위한 생성자 */
    public RacingGame(ArrayList<Car> cars) {
        this.cars = cars;
    }

    private boolean isOverlap(String[] carNames) {
        Set<String> hashSet = new HashSet<>();
        for (String carName : carNames) {
            hashSet.add(carName.trim());
        }
        return carNames.length != hashSet.size();
    }

    public boolean isEqualCarList(List<Car> cars) {
        int index = 0;
        while (index < this.cars.size() && this.cars.get(index).equals(cars.get(index))) {
            index++;
        }
        return index == this.cars.size();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(Random.createRandomNumber());
        }
    }

    public WinningCars getWinnerCars() {
        int maxPosition = START_POSITION;
        WinningCars winningCars = new WinningCars();
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        for (Car car : cars) {
            winningCars.addWinners(car, maxPosition);
        }
        return winningCars;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString()).append("\n");
        }
        return sb.toString();
    }

}
