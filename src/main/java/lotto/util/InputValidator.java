package lotto.util;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

import lotto.config.LottoConstants;

public class InputValidator {

    private static final int VALID_LOTTO_NUMBER_SIZE = 6;
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "올바르지 않은 숫자 형식입니다.";
    private static final String INVALID_NUMBER_BY_NULL = "숫자를 입력해주세요.";
    private static final String INVALID_DUPLICATE_BY_PRIZE_NUMBER = "당첨 번호가 중복되면 안됩니다.";
    private static final String SEPARATOR = ",";
    private static final String INVALID_CONTAINS_SEPARATOR = ", 를 사용해 당첨번호를 구분지어 입력해야 합니다.";
    private static final String INVALID_PRIZE_LOTTO_NUMBER_RANGE = "당첨 번호 입력은 1이상 45이하만 가능합니다.";
    private static final int MIN_PRIZE_LOTTO_NUMBER = 1;
    private static final int MAX_PRIZE_LOTTO_NUMBER = 45;

    private InputValidator() {
    }

    public static int validatePrice(String amountPrice) {
        checkInputNotBlank(amountPrice);
        return toInteger(amountPrice);
    }

    private static int toInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                LottoConstants.ERROR_MESSAGE + INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    public static int validateBonusLottoNumber(String bonusNumber) {
        checkInputNotBlank(bonusNumber);
        return toInteger(bonusNumber);
    }

    public static List<Integer> validatePrizeLottoNumbers(String prizeLottoNumber) {
        checkInputNotBlank(prizeLottoNumber);
        checkContainSeparator(prizeLottoNumber);
        List<Integer> prizeNumber = distinctPrizeLottoNumbers(prizeLottoNumber);
        validatePrizeLottoNumberSize(prizeNumber);
        validPrizeLottoNumberRange(prizeNumber);
        return prizeNumber;
    }

    private static void validPrizeLottoNumberRange(List<Integer> prizeNumber) {
        for (int number : prizeNumber) {
            if (number < MIN_PRIZE_LOTTO_NUMBER || number > MAX_PRIZE_LOTTO_NUMBER) {
                throw new IllegalArgumentException(
                    LottoConstants.ERROR_MESSAGE + INVALID_PRIZE_LOTTO_NUMBER_RANGE);
            }
        }
    }

    private static void checkContainSeparator(String prizeLottoNumber) {
        String[] prizeNumber = prizeLottoNumber.split(SEPARATOR);
        if (prizeNumber.length != VALID_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_CONTAINS_SEPARATOR);
        }
    }


    private static List<Integer> distinctPrizeLottoNumbers(String prizeLottoNumber) {
        return Arrays.stream(prizeLottoNumber.split(SEPARATOR))
            .map(InputValidator::toInteger)
            .distinct()
            .collect(toList());
    }

    private static void validatePrizeLottoNumberSize(List<Integer> prizeLottoNumber) {
        if (prizeLottoNumber.size() != VALID_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_BY_PRIZE_NUMBER);
        }
    }

    private static void checkInputNotBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(
                LottoConstants.ERROR_MESSAGE + INVALID_NUMBER_BY_NULL);
        }
    }
}
