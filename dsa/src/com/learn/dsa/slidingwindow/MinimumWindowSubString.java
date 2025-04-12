package com.learn.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    /*
    * https://leetcode.com/problems/minimum-window-substring/description/
    * 76. Minimum Window Substring
    * */

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> freqMap = new HashMap<>();
        int freqCount = 0;
        for(char c : t.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            freqCount++;
        }
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, minLeft = 0;
        while (right < s.length()){

            char rightChar = s.charAt(right);
            if(freqMap.containsKey(rightChar)) {
                if (freqMap.get(rightChar) > 0) {
                    freqCount--;
                }
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);
            }

                while (freqCount == 0){
                    int len = right - left + 1;

                    if(len < minLength){
                        minLength = len;
                        minLeft =left;
                    }

                    if(freqMap.containsKey(s.charAt(left))){
                        freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) + 1);
                        if(freqMap.get(s.charAt(left)) > 0){
                            freqCount++;
                        }
                    }
                    left++;
                }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    public String minWindowV2(String s, String t) {

        if(s.length() < t.length()) return  "";
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> windowFreqMap = new HashMap<>();
        for(char c : t.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right =0;
        int minLength = Integer.MAX_VALUE, minLeft = 0;
        int matched = 0;
        while (right < s.length()){
            char rightChar = s.charAt(right);
            windowFreqMap.put(rightChar, windowFreqMap.getOrDefault(rightChar, 0) + 1);

            if(freqMap.containsKey(rightChar) && windowFreqMap.get(rightChar).intValue() == freqMap.get(rightChar).intValue()){
                matched++;
            }
            while(matched == freqMap.size()){
                int len = right - left + 1;
                if(len < minLength){
                    minLength = len;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                if(windowFreqMap.containsKey(leftChar)){
                    windowFreqMap.put(leftChar, windowFreqMap.get(leftChar) - 1);
                    if(windowFreqMap.get(leftChar) < freqMap.getOrDefault(leftChar, 0)){
                        matched--;
                    }
                }
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);

    }

    public static void main(String[] args) {
        MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
        System.out.println(minimumWindowSubString.minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(minimumWindowSubString.minWindow("a", "a")); // "a"
        System.out.println(minimumWindowSubString.minWindow("a", "aa")); // ""

        System.out.println(minimumWindowSubString.minWindowV2("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(minimumWindowSubString.minWindowV2("a", "a")); // "a"
        System.out.println(minimumWindowSubString.minWindowV2("a", "aa")); // ""
    }
}
