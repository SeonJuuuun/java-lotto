package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    MISS(0, 0, 0);

    private final int match;
    private final int reward;
    private final int bonus;

    Rank(int match, int bonus, int reward) {
        this.match = match;
        this.reward = reward;
        this.bonus = bonus;
    }

    public static Rank of(int match, int bonusNumber) {
        return Arrays.stream(Rank.values())
            .filter(value -> value.match == match && value.bonus == bonusNumber)
            .findFirst()
            .orElse(MISS);
    }

    public int getMatch() {
        return match;
    }

    public int getReward() {
        return reward;
    }

    public int getBonus() {
        return bonus;
    }
}
