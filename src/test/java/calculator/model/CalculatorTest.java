package calculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {


    @Test
    void 플러스(){
        assertThat(Calculator.plus(1,2)).isEqualTo(3);
        assertThat(Calculator.plus(-5,2)).isEqualTo(-3);
    }

    @Test
    void 마이너스(){
        assertThat(Calculator.minus(2,1)).isEqualTo(1);
    }

    @Test
    void 곱하기(){
        assertThat(Calculator.multiply(1,2)).isEqualTo(2);
        assertThat(Calculator.multiply(1,0)).isEqualTo(0);
    }

    @Test
    void 나누기(){
        assertThat(Calculator.divide(10,2)).isEqualTo(5);
        assertThat(Calculator.divide(9,2)).isEqualTo(4.5);
    }

    @Test
    void 나눌_때_0으로_나누면_Exception_발생(){
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(10,0));
    }
}
