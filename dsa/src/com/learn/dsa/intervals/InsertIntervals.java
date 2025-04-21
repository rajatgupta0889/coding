package com.learn.dsa.intervals;

import java.util.*;

public class InsertIntervals {
    /**
     * https://leetcode.com/problems/insert-interval/
     * 57. Insert Interval
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i =0;
        while (i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while (i <n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while(i < n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);



    }

    public static void main(String[] args) {
        InsertIntervals insertIntervals = new InsertIntervals();
        int[][] intervals = {
                {1,3},
                {6,9}
        };
        int[] newInterval = {2,5};
        int[][] result = insertIntervals.insert(intervals, newInterval);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
