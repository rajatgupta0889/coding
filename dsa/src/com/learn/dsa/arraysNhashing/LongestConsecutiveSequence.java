package com.learn.dsa.arraysNhashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /*
     * https://leetcode.com/problems/longest-consecutive-sequence/
     * 128. Longest Consecutive Sequence
     * */

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxCount = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int count = 0;
                while (set.contains(num++)){
                    count++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{0,0}));
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{1,2,0,1}));
    }
}
