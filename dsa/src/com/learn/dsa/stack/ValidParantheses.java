package com.learn.dsa.stack;

import java.util.Stack;

public class ValidParantheses {

    /**
     *
     *  https://leetcode.com/problems/valid-parentheses/
     * 20. Valid Parentheses
     */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
           if(c == '('){
               stack.push(')');
           }else if(c == '{') {
               stack.push('}');
           }else if(c== '[') {
               stack.push(']');
           }else{
               if(stack.isEmpty() || stack.removeLast() != c){
                   return false;
               }
           }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        ValidParantheses validParantheses = new ValidParantheses();
        System.out.println(validParantheses.isValid("()")); // true
        System.out.println(validParantheses.isValid("()[]{}")); // true
        System.out.println(validParantheses.isValid("(]")); // false
        System.out.println(validParantheses.isValid("([)]")); // false
        System.out.println(validParantheses.isValid("{[]}")); // true
    }
}
