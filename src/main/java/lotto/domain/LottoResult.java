package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final int PERCENT = 100;

    private final Map<Rank, Integer> ranks;

    public LottoResult(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
    }

    public double profitPercent() {
        int sum = 0;
        int totalPrice = 0;
        for (Rank rank : ranks.keySet()) {
            sum += rank.getReward() * ranks.get(rank);
            totalPrice += ranks.get(rank) * ONE_LOTTO_PRICE;
        }
        return (sum * 1.0 / totalPrice) * PERCENT;
    }

    public Map<Rank, Integer> getRanks() {
        List<Rank> rankList = new ArrayList<>(ranks.keySet());
        rankList.remove(Rank.MISS);
        rankList.sort(Collections.reverseOrder());
        Map<Rank, Integer> sortedRanks = new LinkedHashMap<>();
        for (Rank rank : rankList) {
            sortedRanks.put(rank, ranks.get(rank));
        }
        return sortedRanks;
    }
}
