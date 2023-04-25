package me.qna;

public interface I {
    // java 8-: 상수랑 추상메소드만 정의할 수 있었음
    // java 8+: default, static
    int aa = 10; // 상수
    void a(); // 추상 메소드
    default void b() {}
    static void c() {}
}
