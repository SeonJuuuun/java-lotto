package lotto.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @DisplayName("금액 입력을 abc로 입력하면 예외가 발생한다.")
    @Test
    public void testValidatePrice_InvalidFormat_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validatePrice("abc");
        });
    }

    @DisplayName("보너스 번호 입력을 xyz로 입력하면 예외가 발생한다.")
    @Test
    public void testValidateBonusLottoNumber_InvalidFormat_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateBonusLottoNumber("xyz");
        });
    }

    @DisplayName("당첨 번호 입력 시 구분자를 쉼표가 아닌 구분자로 입력하면 예외가 발생한다.")
    @Test
    public void testValidatePrizeLottoNumbers_InvalidSeparator_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validatePrizeLottoNumbers("1.2.3.4.5.6");
        });
    }

    @DisplayName("당첨 번호 입력 시 중복으로 입력하면 예외가 발생한다.")
    @Test
    public void testValidatePrizeLottoNumbers_DuplicateNumbers_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validatePrizeLottoNumbers("1,2,2,3,4,5");
        });
    }

    @DisplayName("당첨 번호 입력 시 로또 범위를 벗어나면 예외가 발생한다.")
    @Test
    public void testValidatePrizeLottoNumbers_InvalidRange_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validatePrizeLottoNumbers("1,2,3,50,45,6");
        });
    }
}
