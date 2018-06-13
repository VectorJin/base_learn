package com.jinku.demo.stack;

import java.util.Stack;

/**
 * Created by jinku on 2018/5/23.
 */
public class StackReverse {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int result = stack.pop();
        reverse(stack);
        System.out.println(result);
        stack.push(result);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        System.out.println(stack);
    }
}
