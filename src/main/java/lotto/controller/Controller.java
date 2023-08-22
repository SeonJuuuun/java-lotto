package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.PlayerLottos;
import lotto.domain.PrizeLotto;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final LottoShop lottoShop;
    private final OutputView outputView;

    public Controller(final InputView inputView, final LottoShop lottoShop,
        final OutputView outputView) {
        this.inputView = inputView;
        this.lottoShop = lottoShop;
        this.outputView = outputView;
    }

    public void play() {
        final PlayerLottos playerLottos = createPlayerLottos();
        final PrizeLotto prizeLotto = createPrizeLotto();
        final LottoResult lottoResult = prizeLotto.judgeLottoNumber(playerLottos);
        printResult(lottoResult);
    }

    private PlayerLottos createPlayerLottos() {
        final int price = inputView.inputPurchaseLotto();
        final List<Lotto> createPlayerLottos = lottoShop.createByPlayerLotto(price);
        outputView.printPlayerLottos(createPlayerLottos.size(), createPlayerLottos);
        return new PlayerLottos(createPlayerLottos);
    }

    private PrizeLotto createPrizeLotto() {
        final List<Integer> inputPrizeLottoNumber = inputView.inputPrizeLottoNumber();
        final Lotto goalLotto = lottoShop.createByPrizeLotto(
            inputPrizeLottoNumber);   // 예외 모음인 클래스를 만들어서
        final int bonusNumber = inputView.inputBonusLottoNumber();
        return new PrizeLotto(goalLotto, bonusNumber);
    }

    private void printResult(LottoResult lottoResult) {
        outputView.printResult(lottoResult.getRanks());
        outputView.printProfitPercent(lottoResult.profitPercent());
    }
}
