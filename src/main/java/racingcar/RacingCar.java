package racingcar;

import racingcar.controller.Controller;
import racingcar.model.CarList;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        Controller controller = new Controller();
        CarList carList = controller.makeCarList(View.inputNameOfCar());

        int numberOfTry = View.inputNumberOfTry();
        for (int i = 0; i < numberOfTry; i++) {
            carList = controller.moveCar(carList);

        }
    }
}
