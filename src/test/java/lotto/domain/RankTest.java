package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("발행한 로또 번호와 당첨번호가 6개가 맞고 보너스번호가 0개를 맞추면 1등을 반환한다.")
    @Test
    void getFirstRank() {
        Rank rank = Rank.of(6, 0);
        assertEquals(Rank.FIRST, rank);
    }
    @DisplayName("발행한 로또 번호와 당첨번호가 5개가 맞고 보너스번호가 1개를 맞추면 2등을 반환한다.")
    @Test
    void getSecondRank() {
        Rank rank = Rank.of(5, 1);
        assertEquals(Rank.SECOND, rank);
    }

    @DisplayName("발행한 로또 번호와 당첨번호가 5개가 맞고 보너스번호가 0개를 맞추면 3등을 반환한다.")
    @Test
    void getThirdRank() {
        Rank rank = Rank.of(5, 0);
        assertEquals(Rank.THIRD, rank);
    }

    @DisplayName("발행한 로또 번호와 당첨번호가 4개가 맞고 보너스번호가 0개를 맞추면 4등을 반환한다.")
    @Test
    void getFourthRank() {
        Rank rank = Rank.of(4, 0);
        assertEquals(Rank.FOURTH, rank);
    }

    @DisplayName("발행한 로또 번호와 당첨번호가 3개가 맞고 보너스번호가 0개를 맞추면 5등을 반환한다.")
    @Test
    void getFifthRank() {
        Rank rank = Rank.of(3, 0);
        assertEquals(Rank.FIFTH, rank);
    }

    @DisplayName("그 이외를 맞추면 MISS를 반환한다.")
    @Test
    void getMissRank() {
        Rank rank = Rank.of(0, 0);
        assertEquals(Rank.MISS, rank);
    }
}
