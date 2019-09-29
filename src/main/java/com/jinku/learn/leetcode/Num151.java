package com.jinku.learn.leetcode;

import java.util.*;

/**
 * 最小栈
 */
public class Num151 {

    public class MinStack {
        Deque<Integer> stack = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new ArrayDeque<>();
        }

        public void push(int x) {
            if (stack.size() == 0) {
                stack.push(x);
                stack.push(x);
                return;
            }
            int pre = stack.peek();
            if (x > pre) {
                stack.push(x);
                stack.push(pre);
            } else {
                stack.push(x);
                stack.push(x);
            }
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            int value = stack.pop();
            int result =  stack.peek();
            stack.push(value);
            return result;
        }

        public int getMin() {
            return stack.peek();
        }
    }

}
