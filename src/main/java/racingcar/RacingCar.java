package racingcar;

import racingcar.controller.Controller;
import racingcar.model.RacingGame;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        Controller controller = new Controller();
        String[] carNames = View.inputNameOfCar();
        String numberOfTry = View.inputNumberOfTry();

        RacingGame racingGame = controller.makeCars(carNames, numberOfTry);
        View.outputLine("실행 결과");

        for (int i = 0; i < Integer.parseInt(numberOfTry); i++) {
            racingGame = controller.playRacing(racingGame);
            View.printCars(racingGame);
        }
        View.printWinningCars(controller.getWinningCars(racingGame));
    }
}
