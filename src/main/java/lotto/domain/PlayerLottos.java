package lotto.domain;

import java.util.List;

public class PlayerLottos {

    private final List<Lotto> lottoNumbers;

    public PlayerLottos(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
}
