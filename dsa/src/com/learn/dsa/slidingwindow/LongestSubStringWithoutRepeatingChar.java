package com.learn.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChar {

    /*
    * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    * 3. Longest Substring Without Repeating Characters
    * */

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for(int right = 0 ; right < s.length(); right++){
            char currentChar = s.charAt(right);
            if(map.containsKey(currentChar) && map.get(currentChar) >= left){
                maxLength = Math.max(maxLength, right - left);
                left = map.get(currentChar) + 1;
            }
            map.put(currentChar, right);
        }

        return Math.max( maxLength, s.length() - left);
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingChar longestSubStringWithoutRepeatingChar = new LongestSubStringWithoutRepeatingChar();
        System.out.println(longestSubStringWithoutRepeatingChar.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(longestSubStringWithoutRepeatingChar.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(longestSubStringWithoutRepeatingChar.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(longestSubStringWithoutRepeatingChar.lengthOfLongestSubstring("")); // 0
    }
}


