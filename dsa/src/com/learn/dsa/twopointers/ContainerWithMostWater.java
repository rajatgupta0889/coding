package com.learn.dsa.twopointers;

public class ContainerWithMostWater {
    /*
    *   https://leetcode.com/problems/container-with-most-water/description/
    *   11. Container With Most Water
    * */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while (left < right){
            int minHeight  = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));
            while (left < right && height[left] <= minHeight){
                left++;
            }
            while (left < right && height[right] <= minHeight){
                right--;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(result); // 49
        result = containerWithMostWater.maxArea(new int[]{1,1});
        System.out.println(result); // 1
        result = containerWithMostWater.maxArea(new int[]{4,3,2,1,4});
        System.out.println(result); // 16
    }

}
