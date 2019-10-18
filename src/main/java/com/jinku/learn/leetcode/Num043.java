package com.jinku.learn.leetcode;

/**
 * 字符串相乘
 * https://blog.csdn.net/u010983881/article/details/77503519
 */
public class Num043 {

    public static void main(String[] args) {
        System.out.println(normal("125", "239"));
    }

    public static String multiply(String num1, String num2) {
        return helper(num1, num2);
    }

    private static String normal(String num1, String num2) {
        String result = "";

        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();

        int length1 = num1.length();
        int length2 = num2.length();

        int[] array = new int[length1 * length2];

        int index = 0;
        for (int i = length2 - 1; i >= 0; i--) {
            int level = length2 - i - 1;
            int point = level;
            int start = index;
            for (int j = length1 - 1; j >= 0; j--) {
                int tmp = (array2[i] - 48) * (array1[j] - 48);

                if (level != 0 && point < start) {
                    index = point;
                    array[index] = array[point] + tmp;
                } else {
                    array[index] = tmp;
                }
                point++;
                index++;
            }
        }

        int plusNum = 0;
        for (int i = 0; i < index;i++) {
            int num = array[i];
            num += plusNum;
            if (num >= 10) {
                plusNum = num / 10;
                result = (num - plusNum * 10) + result;
            } else {
                plusNum = 0;
                result = num + result;
            }
        }
        if (plusNum != 0) {
            result = plusNum + result;
        }

        return result;
    }

    private static String helper(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty()) {
            return "0";
        }

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        boolean negative = false;

        if (num1.startsWith("-")) {
            negative = true;
            num1 = num1.substring(1);
        }

        if (num2.startsWith("-")) {
            num2 = num2.substring(1);
            if (negative) {
                negative = false;
            } else {
                negative = true;
            }
        }

        if (num1.length() <= 128 || num2.length() <= 128) {
            if (negative) {
                return "-" + normal(num1, num2);
            } else {
               return normal(num1, num2);
            }
        }

        int half = Math.max(num1.length(), num2.length()) / 2;
        half = Math.min(Math.min(half, num2.length()), num1.length());

        String aStr = num1.substring(0, num1.length() - half);
        String bStr = num1.substring(num1.length() - half);
        String cStr = num2.substring(0, num2.length() - half);
        String dStr = num2.substring(num2.length() - half);

        String acStr = helper(aStr, cStr);
        String bdStr = helper(bStr, dStr);

        String abStr = plus(aStr, bStr);
        String cdStr = plus(cStr, dStr);
        String ab_cd = helper(abStr, cdStr);
        String ad_plus_bd = minusOrPlus(ab_cd, "-" + acStr, "-" + bdStr);

        String p1 = pow10(acStr, half * 2);
        String p2 = pow10(ad_plus_bd, half);

        String result = minusOrPlus(p1, p2, bdStr);

        if (negative) {
            return "-" + result;
        }
        return result;
    }

    private static String pow10(String str, int n) {
        if (n == 0) {
            return "0";
        }
        for (int i = 0; i < n; i++) {
            str = str + "0";
        }
        return str;
    }

    private static String minusOrPlus(String num1, String num2, String num3) {
        return minusOrPlus(minusOrPlus(num1, num2), num3);
    }

    private static String minusOrPlus(String num1, String num2) {
        if (num1.startsWith("-") && num2.startsWith("-")) {
            return "-" + plus(num1.substring(1), num2.substring(1));
        }

        if (num1.startsWith("-")) {
            return minus(num2, num1);
        }

        if (num2.startsWith("-")) {
            return minus(num1, num2);
        }

        return plus(num1, num2);
    }

    private static String minus(String num1, String num2) {
        String result = "";

        num2 = num2.substring(1);
        if (num1.equals(num2)) {
            return "0";
        }

        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();

        int length1 = num1.length();
        int length2 = num2.length();

        int n = Math.max(length1, length2);
        int[] array = new int[n];

        int index = 0;

        for (int i = 0; i < n; i++) {
            int a = 0;
            int b = 0;

            if (i < length1) {
                a = array1[length1 - 1 - i] - 48;
            }

            if (i < length2) {
                b = array2[length2 - 1 - i] - 48;
            }

            array[index++] = (a - b);
        }

        Boolean isNegative = null;
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] == 0) {
                continue;
            }
            if (array[i] < 0) {
                isNegative = true;
                break;
            }
            if (array[i] > 0) {
                isNegative = false;
                break;
            }
        }
        if (isNegative == null) {
            return "0";
        }

        if (isNegative) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        array1 = num1.toCharArray();
        array2 = num2.toCharArray();

        length1 = num1.length();
        length2 = num2.length();

        boolean minusOne = false;
        for (int i = 0; i < n; i++) {
            int b = 0;

            if (i < length2) {
                b = array2[length2 - 1 - i] - 48;
            }

            int a = 0;
            if (i < length1) {
                a = array1[length1 - 1 - i] - 48;
            }

            if (minusOne) {
                a--;
            }

            if (a - b < 0) {
                result = (10 + a - b) + result;
                minusOne = true;
            } else {
                result = (a - b) + result;
                minusOne = false;
            }
        }
        if (result.startsWith("0")) {
            result = result.substring(1);
        }

        if (isNegative) {
            result = "-" + result;
        }
        return result;
    }

    public static String plus(String num1, String num2) {
        String result = "";

        int n = Math.max(num1.length(), num2.length());
        int[] array = new int[n];

        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();

        int index = 0;
        for (int i = 0; i < n; i++) {
            int a = 0;
            int b = 0;
            if (i < num1.length()) {
                a = array1[num1.length() - 1 - i] - 48;
            }

            if (i < num2.length()) {
                b = array2[num2.length() - 1 - i] - 48;
            }
            array[index++] = (a + b);
        }

        boolean plusOne = false;
        for (int i = 0; i < n; i++) {
            int num = array[i];
            if (plusOne) {
                num++;
            }
            if (num >= 10) {
                plusOne = true;
                result = (num - 10) + result;
            } else {
                plusOne = false;
                result = num + result;
            }
        }
        if (plusOne) {
            result = "1" + result;
        }
        return result;
    }

}
