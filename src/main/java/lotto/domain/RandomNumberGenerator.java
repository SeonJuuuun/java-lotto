package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int START_LOTTO_RANGE = 1;
    private static final int END_LOTTO_RANGE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_LOTTO_RANGE, END_LOTTO_RANGE,
            LOTTO_NUMBER_COUNT);
    }
}
