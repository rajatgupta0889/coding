package com.learn.dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    /*
     * https://leetcode.com/problems/min-stack/
     * 155. Min Stack
     */


    private List<int[]> st;

    public MinStack() {
      st = new ArrayList<>();
    }

    public void push(int val) {
        int[] top = st.isEmpty() ? new int[]{val, val} : st.getLast();
        int min = Math.min(top[1], val);
        st.add(new int[]{val, min});
    }

    public void pop() {
        st.removeLast();
    }

    public int top() {
        return !st.isEmpty() ? st.getLast()[0] : -1;
    }

    public int getMin() {
        return !st.isEmpty() ? st.getLast()[1] : -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
