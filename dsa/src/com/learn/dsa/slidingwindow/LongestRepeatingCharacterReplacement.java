package com.learn.dsa.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    /*
     * https://leetcode.com/problems/longest-repeating-character-replacement/description/
     * 424. Longest Repeating Character Replacement
     * */

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            freq[currentChar - 'A']++;
            maxFreq = Math.max(maxFreq, freq[currentChar - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1)); // 4
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("ABAB", 2)); // 4
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 0)); // 4
    }
}
