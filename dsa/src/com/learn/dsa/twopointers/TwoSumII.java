package com.learn.dsa.twopointers;

public class TwoSumII {

    /*
    * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
    * 167. Two Sum II - Input Array Is Sorted
    * */

    public int[] twoSum(int[] numbers, int target) {
            int start = 0;
            int end = numbers.length - 1;

            while (start < end){
                int sum = numbers[start] + numbers[end];
                if(sum == target){
                    return new int[]{start+1, end+1};
                }
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }

            return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] result = twoSumII.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(result[0] + " " + result[1]);
        result = twoSumII.twoSum(new int[]{2,3,4}, 6);
        System.out.println(result[0] + " " + result[1]);
        result = twoSumII.twoSum(new int[]{-1,0}, -1);
        System.out.println(result[0] + " " + result[1]);
    }
}
