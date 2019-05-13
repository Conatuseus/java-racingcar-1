package racingcar;

import racingcar.controller.Controller;
import racingcar.model.RacingGame;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        Controller controller = new Controller();
        RacingGame racingGame = controller.makeCars(View.inputNameOfCar());

        int numberOfTry = View.inputNumberOfTry();
        View.outputLine("실행 결과");
        for (int i = 0; i < numberOfTry; i++) {
            racingGame = controller.moveCar(racingGame);
            View.printCars(racingGame);
        }
        View.printWinningCars(controller.getWinningCars(racingGame));
    }
}
