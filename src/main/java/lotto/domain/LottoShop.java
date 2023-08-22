package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.config.LottoConstants;

public class LottoShop {

    private static final int ONE_LOTTO_PRICE = 1000;

    private final NumberGenerator numberGenerator;

    public LottoShop(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createByPlayerLotto(int price) {
        validCheckPrice(price);
        int lottoCount = price / ONE_LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(numberGenerator.generate()));
        }
        return lottos;
    }

    public Lotto createByPrizeLotto(List<Integer> inputPrizeLottoNumber) {
        validCheckPrizeLottoNumber(inputPrizeLottoNumber);
        return new Lotto(inputPrizeLottoNumber);
    }

    private void validCheckPrice(int price) {
        checkPriceRange(price);
        checkMoney(price);
    }

    private void checkMoney(int price) {
        if (price % ONE_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(
                LottoConstants.ERROR_MESSAGE + "1000원 단위로 입력을 해야합니다.");
        }
    }

    private void checkPriceRange(int price) {
        if (price < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoConstants.ERROR_MESSAGE + "구입은 1000원부터 가능합니다.");
        }
    }

    private void validCheckPrizeLottoNumber(List<Integer> inputPrizeLottoNumber) {
        checkPrizeLottoRange(inputPrizeLottoNumber);
    }

    private void checkPrizeLottoRange(List<Integer> inputPrizeLottoNumber) {
        for (int lottoNumber : inputPrizeLottoNumber) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new IllegalArgumentException(
                    LottoConstants.ERROR_MESSAGE + "당첨 번호 입력은 1이상 45이하의 숫자만 입력 가능합니다.");
            }
        }
    }
}
