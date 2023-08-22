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

    public List<Integer> inputPrizeLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String prizeLottoNumber = Console.readLine();
        return InputValidator.validatePrizeLottoNumbers(prizeLottoNumber);
    }

    public int inputBonusLottoNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        final String bonusLottoNumber = Console.readLine();
        return InputValidator.validateBonusLottoNumber(bonusLottoNumber);
    }
}
