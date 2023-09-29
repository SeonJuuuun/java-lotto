package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private InputView() {
	}

	public static int inputPurchaseLotto() {
		final String price = Console.readLine();
		validatePrice(price);
		return toInteger(price);
	}

	public static List<Integer> inputPrizeLottoNumber() {
		String prizeLottoNumber = Console.readLine();
		validatePrice(prizeLottoNumber);
		return splitWord(prizeLottoNumber);
	}

	public static int inputBonusLottoNumber() {
		final String bonusLottoNumber = Console.readLine();
		validatePrice(bonusLottoNumber);
		return toInteger(bonusLottoNumber);
	}

	private static int toInteger(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
		}
	}

	private static List<Integer> splitWord(String input) {
		return Arrays.stream(input.split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private static void validatePrice(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 빈 값이 입력되었습니다.");
		}
	}
}
