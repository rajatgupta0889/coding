package com.learn.dsa.twopointers;

public class ValidPalindrome {

    /*
    *   https://leetcode.com/problems/valid-palindrome/description/
    *   125 Valid Palindrome
    * */
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;

        while (start < end){
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }

            while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }

            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome  = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
        System.out.println(validPalindrome.isPalindrome(" "));
    }

}
