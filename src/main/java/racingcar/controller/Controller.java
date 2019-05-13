package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.WinningCars;


public class Controller {

    public RacingGame makeCars(String[] carNames) {
        RacingGame racingGame = new RacingGame(carNames);
        return racingGame;
    }

    public RacingGame moveCar(RacingGame racingGame) {
        racingGame.moveCars();
        return racingGame;
    }

    public WinningCars getWinningCars(RacingGame racingGame) {
        return racingGame.getWinnerCars();
    }
}
