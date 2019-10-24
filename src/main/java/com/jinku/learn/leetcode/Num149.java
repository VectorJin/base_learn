package com.jinku.learn.leetcode;

/**
 * 直线上最多的点数
 */
public class Num149 {

    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{84, 250}, {0, 0}, {1, 0}, {0, -70}, {1, -1}, {21, 10}, {42, 90}, {-42, -230}}));
    }

    public static int maxPoints(int[][] points) {

        if (points == null) {
            return 0;
        }

        if (points.length <= 2) {
            return points.length;
        }
        int size = (points.length * (points.length - 1)) / 2;
        Line[] lineArray = new Line[size];
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    // 相同点过滤
                    continue;
                }
                lineArray[index++] = new Line(new Point(points[i], i), new Point(points[j], j));
            }
        }
        // 都相同，直接返回个数
        if (index == 0) {
            return points.length;
        }

        // 处理相同点
        int max = 0;
        for (int j = 0; j < index; j++) {
            Line line = lineArray[j];
            int count = 2;
            for (int i = 0; i < points.length; i++) {
                if (line.p1.index == i || line.p2.index == i) {
                    continue;
                }

                if (count + (points.length - i + 1) <= max) {
                    break;
                }

                Point p = new Point(points[i], i);

                if (isInLine(line, p)) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                if (max > (points.length / 2 + 1)) {
                    return max;
                }
            }
        }

        return max;
    }

    public static class Line {
        Point p1;
        Point p2;

        Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    public static class Point {
        int x;
        int y;
        Integer index;

        public Point(int[] p, int index) {
            this.x = p[0];
            this.y = p[1];
            this.index = index;
        }

        public Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    private static boolean isInLine(Line line, Point p) {
        long left = (long) (p.x - line.p1.x) * (long) (line.p2.y - line.p1.y);
        long right = (long) (p.y - line.p1.y) * (long) (line.p2.x - line.p1.x);
        return left == right;
    }
}
