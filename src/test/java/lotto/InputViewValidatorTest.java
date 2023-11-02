package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setInputValidator() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("입력값이 숫자인지 확인합니다.")
    void checkNumber() {
        String testNumber = "k";

        Assertions.assertThatThrownBy(() -> inputValidator.checkInputDigit(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("공백을 입력했는지 확인합니다.")
    void checkBlack() {
        String testNumber = " ";

        Assertions.assertThatThrownBy(() -> inputValidator.checkInputBlank(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_BLANK_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("아무 값도 입력하지 않았는지 확인합니다.")
    void checkEmpty() {
        String testNumber = "";

        Assertions.assertThatThrownBy(() -> inputValidator.checkInputEmpty(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INPUT_EMPTY_MESSGAE.getMessage());
    }
}
