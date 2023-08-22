package lotto.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lotto.config.LottoConstants;

public class PrizeLotto {

    private final Lotto prizeLotto;
    private final int bonusNumber;

    public PrizeLotto(Lotto prizeLotto, int bonusNumber) {
        checkDuplicatePrizeLottoNumberBonusLottoNumber(prizeLotto, bonusNumber);
        checkBonusLottoNumberRange(bonusNumber);
        this.prizeLotto = prizeLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult judgeLottoNumber(PlayerLottos playerLottos) {
        Map<Rank, Integer> ranks = initRanks();
        for (Lotto playerLotto : playerLottos.getLottoNumbers()) {
            Rank rank = playerLotto.containsLotto(prizeLotto, bonusNumber);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
        return new LottoResult(ranks);
    }

    private Map<Rank, Integer> initRanks() {
        Map<Rank, Integer> ranks = new HashMap<>();
        for (Rank value : Rank.values()) {
            ranks.put(value, 0);
        }
        return ranks;
    }

    private void checkDuplicatePrizeLottoNumberBonusLottoNumber(Lotto prizeLotto, int bonusNumber) {
        if (prizeLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(
                LottoConstants.ERROR_MESSAGE + "보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    private void checkBonusLottoNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(
                LottoConstants.ERROR_MESSAGE + "보너스 번호의 입력은 1이상 45이하만 가능합니다.");
        }
    }
}