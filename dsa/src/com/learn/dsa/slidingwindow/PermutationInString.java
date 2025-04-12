package com.learn.dsa.slidingwindow;

public class PermutationInString {
    /*
    * https://leetcode.com/problems/permutation-in-string/description/
    * 567. Permutation in String
    * */

    public boolean checkInclusion(String s1, String s2) {
            if(s1.length() > s2.length()) return false;

            int[] s1Array = new int[26];
            int[] s2Array = new int[26];

            for(int i = 0; i < s1.length(); i++){
                s1Array[s1.charAt(i) - 'a']++;
                s2Array[s2.charAt(i) - 'a']++;
            }
            int left = 0;
            int right = s1.length();

            while (right < s2.length()){
                if(isArraySame(s1Array, s2Array)) return true;
                s2Array[s2.charAt(right) - 'a']++;
                s2Array[s2.charAt(left) - 'a']--;
                left++;
                right++;
            }

            return isArraySame(s1Array, s2Array);
    }

    private boolean isArraySame(int[] s1Array, int[] s2Array) {

        for (int i = 0; i < s1Array.length; i++) {
            if(s1Array[i] != s2Array[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("ab", "eidbaooo")); // true
        System.out.println(permutationInString.checkInclusion("ab", "eidboaoo")); // false
        System.out.println(permutationInString.checkInclusion("abc", "ccccbbbbaaaa")); // false
    }
}
