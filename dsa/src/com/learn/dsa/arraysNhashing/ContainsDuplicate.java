package com.learn.dsa.arraysNhashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /*
    * https://leetcode.com/problems/contains-duplicate
    * 217. Contains Duplicate
     * */

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
