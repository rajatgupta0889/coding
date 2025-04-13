package com.learn.dsa.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /**
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/
     * 150. Evaluate Reverse Polish Notation
     * */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int result = switch (token) {
                    case "*" -> a * b;
                    case "+" -> a + b;
                    case "-" -> b - a;
                    case "/" -> b / a;
                    default -> 0;
                };

                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evaluateReversePolishNotation.evalRPN(tokens)); // 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evaluateReversePolishNotation.evalRPN(tokens2)); // 6

        String[] tokens3 = {"10", "6", "9", "3", "/", "-", "*"};
        System.out.println(evaluateReversePolishNotation.evalRPN(tokens3)); // -60
    }

}
