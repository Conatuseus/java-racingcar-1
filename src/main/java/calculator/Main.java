package calculator;

import calculator.model.CalculateQueue;
import calculator.view.View;

public class Main {
    public static void main(String[] args) {
        String[] input = View.input();
        CalculateQueue calculateQueue = new CalculateQueue(input);
        System.out.println(calculateQueue.calculate());
    }
}
