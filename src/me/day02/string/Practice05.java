package me.day02.string;

class Solution {
    public boolean isPalindrome(String s) { // 회문
        String newStr = s.toLowerCase().replaceAll("[^0-9a-z]", "");
//        if (newStr.length() == 0) return true;

//        String reversed = new StringBuilder(newStr).reverse().toString();
//        return newStr.equals(reversed);

        int newStrLen = newStr.length();
        for (int i = 0; i < newStrLen / 2; i++) {
            int j = newStrLen - 1 - i;
            if (newStr.charAt(i) != newStr.charAt(j)) return false;
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
