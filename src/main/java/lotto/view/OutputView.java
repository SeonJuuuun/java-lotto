package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    public void printPlayerLottos(int count, List<Lotto> lottoNumbers) {
        System.out.println(count + "개를 구매했습니다.");
        lottoNumbers.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResult(Map<Rank, Integer> ranks) {
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println("당첨 통계\n" + "---");
        for (Rank rank : ranks.keySet()) {
            printBonusLotto(ranks, nf, rank);
            printLotto(ranks, nf, rank);
        }
    }

    private void printLotto(Map<Rank, Integer> ranks, NumberFormat nf, Rank rank) {
        if (rank.getBonus() == 1) {
            System.out.println(
                rank.getMatch() + "개 일치, 보너스 볼 일치 (" + nf.format(rank.getReward()) + "원) - "
                    + ranks.get(rank)
                    + "개");
        }
    }

    private void printBonusLotto(Map<Rank, Integer> ranks, NumberFormat nf, Rank rank) {
        if (rank.getBonus() == 0) {
            System.out.println(
                rank.getMatch() + "개 일치 (" + nf.format(rank.getReward()) + "원) - " + ranks.get(rank)
                    + "개");
        }
    }

    public void printProfitPercent(double profitPercent) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitPercent) + "%입니다.");
    }
}




