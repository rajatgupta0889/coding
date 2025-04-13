package com.learn.dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    /**
     * https://leetcode.com/problems/generate-parentheses/
     * 22. Generate Parentheses
     */

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        generateParenthesisHelper(result, stringBuilder, 0, 0, n);

        return result;
    }

    private void generateParenthesisHelper(List<String> result, StringBuilder stringBuilder, int openCount, int closedCount, int n) {

        if(openCount == n && closedCount == n){
            result.add(stringBuilder.toString());
            return;
        }

        if(openCount<n){
            stringBuilder.append('(');
            generateParenthesisHelper(result, stringBuilder, openCount + 1, closedCount, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if(closedCount < openCount){
            stringBuilder.append(')');
            generateParenthesisHelper(result, stringBuilder, openCount, closedCount + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParantheses generateParantheses = new GenerateParantheses();
        List<String> result = generateParantheses.generateParenthesis(3);
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println(" ");
        result = generateParantheses.generateParenthesis(1);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}
