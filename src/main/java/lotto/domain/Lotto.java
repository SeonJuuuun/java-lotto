package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

	private static final int MAX_LOTTO_SIZE = 6;

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateNoDuplicateNumbers(numbers);
		this.numbers = sortedNumbers(numbers);
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != MAX_LOTTO_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private void validateNoDuplicateNumbers(List<Integer> numbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(numbers);
		if (uniqueNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
		}
	}

	public Rank containsLotto(Lotto prizeLotto, int bonus) {
		int match = 0;
		int bonusNumber = 0;
		for (int prizeLottoNumber : prizeLotto.numbers) {
			if (numbers.contains(prizeLottoNumber)) {
				match++;
			}
		}
		if (numbers.contains(bonus)) {
			bonusNumber++;
			return Rank.of(match, bonusNumber);
		}
		return Rank.of(match, bonusNumber);
	}

	private List<Integer> sortedNumbers(List<Integer> numbers) {
		List<Integer> integers = new ArrayList<>(numbers);
		Collections.sort(integers);
		return integers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
