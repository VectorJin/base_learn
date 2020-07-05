package com.jinku.learn.leetcode;

import java.util.LinkedList;

/**
 * 用两个栈实现队列
 */
public class Offer09 {

    class CQueue {

        LinkedList<Integer> forAdd;
        LinkedList<Integer> forDelete;

        public CQueue() {
            forAdd = new LinkedList<>();
            forDelete = new LinkedList<>();
        }

        public void appendTail(int value) {
            forAdd.push(value);
        }

        public int deleteHead() {
            if (!forDelete.isEmpty()) {
                return forDelete.poll();
            }

            while (!forAdd.isEmpty()) {
                forDelete.push(forAdd.poll());
            }
            if (forDelete.isEmpty()) {
                return -1;
            }
            return forDelete.poll();
        }
    }
}
