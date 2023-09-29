package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.domain.PlayerLottos;
import lotto.domain.PrizeLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

	private final LottoShop lottoShop;

	public Controller(LottoShop lottoShop) {
		this.lottoShop = lottoShop;
	}

	public void play() {
		final PlayerLottos playerLottos = createPlayerLottos();
		final PrizeLotto prizeLotto = createPrizeLotto();
		final LottoResult lottoResult = prizeLotto.judgeLottoNumber(playerLottos);
		printResult(lottoResult);
	}

	private PlayerLottos createPlayerLottos() {
		OutputView.printPurchaseLotto();
		final int price = inputPurchaseLotto();
		final List<Lotto> createPlayerLottos = lottoShop.createByPlayerLotto(price);
		OutputView.printPlayerLottos(createPlayerLottos.size(), createPlayerLottos);
		return new PlayerLottos(createPlayerLottos);
	}

	private PrizeLotto createPrizeLotto() {
		OutputView.printPrizeLottoNumber();
		final List<Integer> inputPrizeLottoNumber = inputPrizeLotto();
		final Lotto goalLotto = lottoShop.createByPrizeLotto(
			inputPrizeLottoNumber);   // 예외 모음인 클래스를 만들어서
		OutputView.printBonusLottoNumber();
		final int bonusNumber = inputBonusLottoNumber();
		return new PrizeLotto(goalLotto, bonusNumber);
	}

	private int inputBonusLottoNumber() {
		try {
			return InputView.inputBonusLottoNumber();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputPurchaseLotto();
		}
	}

	private int inputPurchaseLotto() {
		try {
			return InputView.inputPurchaseLotto();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputPurchaseLotto();
		}
	}

	private List<Integer> inputPrizeLotto() {
		try {
			return InputView.inputPrizeLottoNumber();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputPrizeLotto();
		}
	}

	private void printResult(LottoResult lottoResult) {
		OutputView.printResult(lottoResult.getRanks());
		OutputView.printProfitPercent(lottoResult.profitPercent());
	}
}
