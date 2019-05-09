package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class WinningCars {
    private List<String> winningCarNames=new ArrayList<>();

    public void addWinningCar(String name){
        winningCarNames.add(name);
    }

}
