package com.jinku.learn.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 */
public class Num020 {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character character = stack.peek();
                if (ch == ')' && character != '(') {
                    return false;
                }
                if (ch == ']' && character != '[') {
                    return false;
                }
                if (ch == '}' && character != '{') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


}
