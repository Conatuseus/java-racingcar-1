package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.WinningCars;


public class Controller {

    public Cars makeCarList(String[] carNames) {
        Cars cars = new Cars(carNames);
        return cars;
    }

    public Cars moveCar(Cars cars) {
        cars.moveCars();
        return cars;
    }

    public WinningCars getWinningCars(Cars cars) {
        return cars.getWinnerCars();
    }
}
