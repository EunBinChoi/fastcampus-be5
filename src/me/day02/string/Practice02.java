package me.day02.string;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // test case
        for (int i = 0; i < T; i++) { // 2
            int r = scanner.nextInt(); // repeat (3)
            String s = scanner.next(); // string (abc)

            // \: escape
            String reg = "^[0-9A-Z\\$%*+-./:]{1,20}$";
            String ans = "";

            if(!Pattern.matches(reg, s)) break;

            for (int j = 0; j < s.length(); j++) { // a b c
                for (int k = 0; k < r; k++) { // 3
                    ans += s.charAt(j);
                }
            }
            System.out.println(ans);
            scanner.close();
        }

    }
}
