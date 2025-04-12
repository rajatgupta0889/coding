package com.learn.dsa.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
    * https://leetcode.com/problems/3sum/description/
    * 15. 3Sum
    * */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i =0; i< n; i++){
            int j = i+1;
            int k = n-1;

            if(i >0 && nums[i] == nums[i-1]) continue;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum== 0){
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }else if(sum < 0) {
                    j++;
                }else{
                    k--;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] input = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum.threeSum(input);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
