package me.day14.junit.overview;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


// 1000원을 주면 1개의 로또를 생성해주는 클래스
/*
* 1. money가 올바른 금액이 아닐 때
* 2. 로또번호가 6개 아닐 때
* 3. 로또번호가 1 ~ 45 사이가 아닐 때
* */
public class LottoNumberGenerator { // 1 ~ 45번 6개
    public List<Integer> generate(final int money) { // test code: 3개 (개발할 때 개발자가 고려한 사항)
        // 새로운 기능 추가

        if (!isValidMoney(money)) {
            throw new RuntimeException("올바른 금액이 아닙니다.");
        }

        // 새로운 기능 추가
        return generate();
    }

    private boolean isValidMoney(final int money) {
        return money == 1000;
    }

    private List<Integer> generate() {
        return new Random()
                .ints(1, 45 + 1)
                .distinct() // 중복 제거
                .limit(6) // 6개까지 만들겠다!
                .boxed() // int -> Integer
                .collect(Collectors.toList());
    }
}
