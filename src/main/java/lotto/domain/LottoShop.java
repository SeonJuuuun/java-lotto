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
