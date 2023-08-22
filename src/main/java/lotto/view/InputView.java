package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputValidator;

public class InputView {

    public int inputPurchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        final String price = Console.readLine();
        return InputValidator.validatePrice(price);
    }
}
