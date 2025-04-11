package com.learn.dsa.arraysNhashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
    * https://leetcode.com/problems/two-sum/
    * 1. Two Sum
     * */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i< nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1,-1}; // Return -1, -1 if no solution is found
    }

    public static void main(String[] args) {

        TwoSum  twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(new int[]{2,7,11,15}, 9)[0]);

    }
}
