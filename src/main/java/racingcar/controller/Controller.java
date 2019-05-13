package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.WinningCars;


public class Controller {

    public RacingGame makeCars(String[] carNames, String numberOfTry) {
        return new RacingGame(carNames, numberOfTry);
    }

    public RacingGame playRacing(RacingGame racingGame) {
        racingGame.moveCars();
        return racingGame;
    }

    public WinningCars getWinningCars(RacingGame racingGame) {
        return racingGame.getWinnerCars();
    }
}