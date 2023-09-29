package lotto;

import lotto.controller.Controller;
import lotto.domain.LottoShop;
import lotto.domain.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new LottoShop(new RandomNumberGenerator()));
        try {
            controller.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
