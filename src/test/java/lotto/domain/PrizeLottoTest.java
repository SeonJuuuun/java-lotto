package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeLottoTest {

    @DisplayName("당첨번호와 보너스 번호가 중복이되면 예외가 발생한다.")
    @Test
    void createPrizeLottoWithDuplicateNumber() {
        Lotto prizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 5;

        assertThrows(IllegalArgumentException.class, () -> new PrizeLotto(prizeLotto, bonusNumber));
    }

    @DisplayName("당첨 번호가 맞더라도 보너스 번호가 범위에 맞지 않으면 예외가 발생한다.")
    @Test
    void createPrizeLottoWithInvalidBonusNumber() {
        Lotto prizeLotto = new Lotto(Arrays.asList(10, 20, 30, 40, 5, 6));
        int invalidBonusNumber = 0;

        assertThrows(IllegalArgumentException.class,
            () -> new PrizeLotto(prizeLotto, invalidBonusNumber));
    }

    @DisplayName("보너스 번호 입력시 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createPrizeLottoWithInvalidBonusNumberRange() {
        Lotto prizeLotto = new Lotto(Arrays.asList(10, 20, 30, 40, 5, 6));
        int invalidBonusNumber = 49;

        assertThrows(IllegalArgumentException.class,
            () -> new PrizeLotto(prizeLotto, invalidBonusNumber));
    }
}
