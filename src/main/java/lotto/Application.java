package lotto;

import lotto.controller.Controller;
import lotto.domain.LottoShop;
import lotto.domain.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new InputView(),
            new LottoShop(new RandomNumberGenerator()), new OutputView());
        try {
            controller.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
