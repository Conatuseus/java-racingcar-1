package racingcar;

import racingcar.controller.Controller;
import racingcar.model.Cars;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Cars cars = controller.makeCarList(View.inputNameOfCar());

        int numberOfTry = View.inputNumberOfTry();
        View.outputLine("실행 결과");
        for (int i = 0; i < numberOfTry; i++) {
            cars = controller.moveCar(cars);
            View.printCars(cars);
        }
        View.printWinningCars(controller.getWinningCars(cars));
    }
}
