package me.day01.operator_practice;

public class Practice07 {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        int res = ((i < j) || (i == 3)) ? i : j;
        /*
         * res 는 i와 j를 비교할 때 i가 j보다 작기 때문에
         * 첫번째 조건식 (i < j) 만 확인 후 true 가 되면
         * 뒤에 있는 조건식 (i == 3) 을 확인하지 않고 바로 true 를 반환함
         * */
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("res = " + res);
    }
}