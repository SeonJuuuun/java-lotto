package lotto;

import java.util.Arrays;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.Lotto;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 자릿수가 6자리가 아니면 예외가 발생한다.")
    @Test
    void createLottoWithInvalidNumberCount() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(invalidNumbers));
    }

    @DisplayName("로또 번호가 중복이 되면 예외가 발생한다.")
    @Test
    void createLottoWithDuplicateNumbers() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 1);
        assertThrows(IllegalArgumentException.class, () -> new Lotto(duplicateNumbers));
    }

    @DisplayName("생성한 로또와 당첨 로또가 맞는게 하나도 없으면 MISS가 뜬다")
    @Test
    void containsLottoWithNoMatches() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);

        List<Integer> prizeNumbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto prizeLotto = new Lotto(prizeNumbers);

        Rank rank = lotto.containsLotto(prizeLotto, 0);
        assertEquals(Rank.MISS, rank);
    }
}
