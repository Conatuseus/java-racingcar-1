package calculator.view;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {

    @Test
    void 숫자인지_확인한다(){
        assertThat(InputValidator.isNumber("5")).isEqualTo(true);
        assertThat(InputValidator.isNumber("-1234")).isEqualTo(true);
        assertThat(InputValidator.isNumber("0")).isEqualTo(true);
        assertThat(InputValidator.isNumber("qweacxz")).isEqualTo(false);
        assertThat(InputValidator.isNumber("+")).isEqualTo(false);
        assertThat(InputValidator.isNumber("/////")).isEqualTo(false);
        assertThat(InputValidator.isNumber(" ")).isEqualTo(false);
    }

    @Test
    void 연산자인지_확인한다(){
        assertThat(InputValidator.isOperator("+")).isEqualTo(true);
        assertThat(InputValidator.isOperator("-")).isEqualTo(true);
        assertThat(InputValidator.isOperator("*")).isEqualTo(true);
        assertThat(InputValidator.isOperator("/")).isEqualTo(true);
        assertThat(InputValidator.isOperator("++++")).isEqualTo(false);
        assertThat(InputValidator.isOperator(" ")).isEqualTo(false);
        assertThat(InputValidator.isOperator("asdfqwer")).isEqualTo(false);
        assertThat(InputValidator.isOperator("1292")).isEqualTo(false);
    }

    @Test
    void 인덱스가_짝수면_숫자_홀수면_연산자인지_검사한다(){
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 + 2 - 3 * 4 / 5".split(" "),0)).isEqualTo(true);
        assertThat(InputValidator.isOperatorOrNumberByIndex("+ 1 2 - 3 * 4 / 5".split(" "),0)).isEqualTo(false);
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 + 2 - 3 * 4 / 5".split(" "),1)).isEqualTo(true);
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 2 2 - 3 * 4 / 5".split(" "),1)).isEqualTo(false);
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 + 2 - 3 * 4 / 5".split(" "),2)).isEqualTo(true);
        assertThat(InputValidator.isOperatorOrNumberByIndex("1 + * - 3 * 4 / 5".split(" "),2)).isEqualTo(false);
    }

    @Test
    void 올바른_입력_순서인지_검사한다(){
        assertThat(InputValidator.isRightSequence("1 + 2 - 3".split(" "))).isEqualTo(true);
        assertThat(InputValidator.isRightSequence("1+2-3".split(" "))).isEqualTo(false);
        assertThat(InputValidator.isRightSequence("1".split(" "))).isEqualTo(true);
        assertThat(InputValidator.isRightSequence("* + s - 3".split(" "))).isEqualTo(false);
        assertThat(InputValidator.isRightSequence("1 + /".split(" "))).isEqualTo(false);
    }

    @Test
    void 올바른_입력인지_검사한다(){
        assertThat(InputValidator.isValid("1 + 2 / 3 * 4".split(" "))).isEqualTo(true);
        assertThat(InputValidator.isValid("+ 1 - 2 * 3".split(" "))).isEqualTo(false);
        assertThat(InputValidator.isValid("1  + 2".split(" "))).isEqualTo(false);
        assertThat(InputValidator.isValid("123 * 100".split(" "))).isEqualTo(true);
        assertThat(InputValidator.isValid("1234".split(" "))).isEqualTo(true);
    }


}
