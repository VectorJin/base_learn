package com.jinku.learn.leetcode;

import java.util.*;

/**
 * 课程表 III
 */
public class Num630 {

    public static void main(String[] args) {
        System.out.println(scheduleCourse(new int[][]{{7,17}, {3,12}, {10,20}, {9,10}, {5,20},{10,19},{4,18}}));
    }

    public static int scheduleCourse(int[][] courses) {
        // 构造大顶推
        PriorityQueue<Course> priorityQueue = new PriorityQueue<>(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o2.costDays.compareTo(o1.costDays);
            }
        });

        List<Course> courseList = new ArrayList<>();
        for (int[] array : courses) {
            Course course = new Course();
            course.costDays = array[0];
            course.closedDay = array[1];
            courseList.add(course);
        }
        Collections.sort(courseList);

        int days = 0;
        for (Course course : courseList) {
            if (course.costDays + days <= course.closedDay) {
                priorityQueue.add(course);
                days += course.costDays;
            } else if (!priorityQueue.isEmpty()) {
                int diff = priorityQueue.peek().costDays - course.costDays;
                if (diff > 0) {
                    days = days - diff;
                    priorityQueue.poll();
                    priorityQueue.add(course);
                }
            }
        }
        return priorityQueue.size();
    }

    public static class Course implements Comparable<Course> {
        Integer costDays;
        Integer closedDay;

        @Override
        public int compareTo(Course o) {
            return closedDay.compareTo(o.closedDay);
        }
    }
}
