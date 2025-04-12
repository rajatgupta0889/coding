package com.learn.dsa.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    /*
    * https://leetcode.com/problems/sliding-window-maximum/description/
    * 239. Sliding Window Maximum
    * */

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int [n-k +1];
        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0;

        for(int i = 0; i< n; i++){
            if(!deque.isEmpty() && deque.peek() < start){
                deque.poll();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }

            deque.add(i);
            if(i >= k-1){
                result[start++] = nums[deque.getFirst()];
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println(" ");
        result = slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
