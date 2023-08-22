package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {

    private NumberGenerator numberGenerator;
    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        numberGenerator = mock(NumberGenerator.class);
        lottoShop = new LottoShop(numberGenerator);
    }

    @DisplayName("구매금액이 500원이면 예외가 발생한다.")
    @Test
    void createByPlayerLottoWithInvalidPrice() {
        assertThrows(IllegalArgumentException.class, () -> lottoShop.createByPlayerLotto(500));
    }

    @DisplayName("구매금액이 2000원이면 로또 2장이 발행된다.")
    @Test
    void createByPlayerLottoWithValidPrice() {
        when(numberGenerator.generate()).thenReturn(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = lottoShop.createByPlayerLotto(2000);

        assertEquals(2, lottos.size());
    }
}
