package com.jinku.learn.leetcode;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class Offer41 {
    class MedianFinder {
        PriorityQueue<Integer> bigHeap;
        PriorityQueue<Integer> smallHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            bigHeap = new PriorityQueue<>((x, y) -> y - x);
            smallHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            Integer mid = bigHeap.peek();
            if (mid == null || num <= mid) {
                bigHeap.add(num);
                if (bigHeap.size() > (smallHeap.size() + 1)) {
                    smallHeap.add(bigHeap.poll());
                }
            } else {
                smallHeap.add(num);
                if (smallHeap.size() > (bigHeap.size())) {
                    bigHeap.add(smallHeap.poll());
                }
            }
        }

        public double findMedian() {
            Integer mid1 = bigHeap.peek();
            Integer mid2 = smallHeap.peek();
            mid1 = mid1 == null ? 0 : mid1;
            mid2 = mid2 == null ? 0 : mid2;
            if ((bigHeap.size() + smallHeap.size()) % 2 == 0) {
                return (mid1 + mid2) / 2.0;
            }
            return mid1;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
