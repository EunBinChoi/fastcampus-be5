package me.day02.string_practice;

class Solution {
    public boolean isPalindrome(String s) { // 회문
        String newStr = s.toLowerCase().replaceAll("[^0-9a-z]", "");

        // string method
//        String reversed = new StringBuilder(newStr).reverse().toString();
//        return newStr.equals(reversed);


        // two pointer
        int j = newStr.length() - 1;
        for (int i = 0; i < newStr.length() / 2; i++) {
            if (newStr.charAt(i) != newStr.charAt(j)) return false;
            j--;
        }
        return true;
    }
}

public class Practice05 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("mom"));
        System.out.println(new Solution().isPalindrome(" "));
        System.out.println(new Solution().isPalindrome("race a car"));
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
