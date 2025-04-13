package com.learn.dsa.stack;

import java.util.Stack;

public class DailyTemperature {

    /**
     * https://leetcode.com/problems/daily-temperatures/
     * 739. Daily Temperatures
     * */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();

        int[] result = new int[temperatures.length];

        for(int i =0; i< temperatures.length; i++){
            int t = temperatures[i];

            while (!stack.isEmpty() && t > stack.peek()[0]){
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }

            stack.push(new int[]{t,i});
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperature.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = dailyTemperature.dailyTemperatures(temperatures2);
        for (int i : result2) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        int[] temperatures3 = {30, 60, 90};
        int[] result3 = dailyTemperature.dailyTemperatures(temperatures3);
        for (int i : result3) {
            System.out.print(i + " ");
        }
    }
}
