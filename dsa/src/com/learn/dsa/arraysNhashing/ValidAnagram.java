package com.learn.dsa.arraysNhashing;

public class ValidAnagram {

    /*
    * https://leetcode.com/problems/valid-anagram/description/
    * 242. Valid Anagram
    * */

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] sArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(sArray[t.charAt(i) - 'a'] == 0)
                return false;
            sArray[t.charAt(i) - 'a']--;
        }
        return isArraySame(sArray);
    }

    private boolean isArraySame(int[] sArray) {

        for (int j : sArray) {
            if (j > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();

        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagram("rat", "car"));
    }
}
