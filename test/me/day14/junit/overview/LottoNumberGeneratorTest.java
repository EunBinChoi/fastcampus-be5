package me.day14.junit.overview;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// 1000원을 주면 1개의 로또를 생성해주는 클래스
public class LottoNumberGeneratorTest { // 1 ~ 45번 6개

    // 위와 같은 로또 번호 생성 코드에 대한 테스트 코드들을 작성
    // 1. 로또 번호 갯수 테스트
    // 2. 로또 번호 범위 테스트
    // 3. 잘못된 로또 금액 테스트

    // 로또_금액_성공_테스트 (1000)
    // 로또_금액_실패_테스트 (2000)
    // 로또_번호_갯수_테스트 (limit())
    // 로또_번호_범위_테스트 (ints())
    // 로또_번호_중복_테스트 (distinct())
    // 로또_번호_타입_테스트 (Integer)

    ///////////////////////////////
    // 자바 --> 외부 라이브러리
    // 자바 --> 외부 리소스
    // 데이터베이스_커넥션_테스트
    // 데이터베이스_삽입_성공_테스트
    // 데이터베이스_삽입_실패_테스트
    // 데이터베이스_삽입_실패_테스트
    LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void before() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @AfterEach
    void after() {
        lottoNumberGenerator = null;
    }

    @DisplayName("로또 번호 갯수 테스트")
    @Test
    void lottoNumberSizeTest() {
        // given
        final int price = 1000;

        // when
        final List<Integer> lotto = lottoNumberGenerator.generate(price);

        // then
        assertEquals(lotto.size(), 6);
    }

    @DisplayName("로또 번호 범위 테스트")
    @Test
    void lottoNumberRangeTest() {
        // given
        final int price = 1000;

        // when
        final List<Integer> lotto = lottoNumberGenerator.generate(price);

        // then
        assertTrue(lotto.stream().allMatch(i -> (i >= 1 && i <= 45)));

    }

    @DisplayName("잘못된 로또 금액 테스트")
    @Test
    void lottoNumberInvalidMoneyTest() {
        // given
        final int price = 2000;

        // when
        final RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> lottoNumberGenerator.generate(price));

        // then
        assertEquals(exception.getMessage(), "올바른 금액이 아닙니다.");
    }

}
