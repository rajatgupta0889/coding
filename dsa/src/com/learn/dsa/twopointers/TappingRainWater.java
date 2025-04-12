package com.learn.dsa.twopointers;

public class TappingRainWater {
    /*
    * https://leetcode.com/problems/trapping-rain-water/description/
    * 42. Trapping Rain Water
    *
    * Solution:
    *   check leftMax and right Max then
    *   find min to calculate the water
    * */

    public int trap(int[] height) {
//        int n = height.length;
//        if(n == 0) return 0;
//        int left = 0;
//        int right = n - 1;
//        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
//        int tappedWater= 0;
//
//        while (left < right){
//            if(height[left] < height[right]){
//                leftMax  = Math.max(leftMax, height[left]);
//                tappedWater  += leftMax - height[left];
//                left++;
//            }else{
//                rightMax = Math.max(rightMax, height[right]);
//                tappedWater += rightMax - height[right];
//                right--;
//            }
//        }
//        return tappedWater;

        int l = 0, r = height.length - 1;
        int lmax = 0, rmax = 0, ans = 0;

        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                ans += lmax - height[l];
                l++;
            } else {
                ans += rmax - height[r];
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TappingRainWater tappingRainWater = new TappingRainWater();
        int result = tappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(result); // 6
        result = tappingRainWater.trap(new int[]{4,2,0,3,2,5});
        System.out.println(result); // 9
        result = tappingRainWater.trap(new int[]{4,2,3});
        System.out.println(result); // 1
    }
}
