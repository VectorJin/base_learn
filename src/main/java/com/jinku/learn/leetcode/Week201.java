package com.jinku.learn.leetcode;

public class Week201 {

    class Solution1 {
        public String makeGood(String s) {
            while (true) {
                String newStr = s;
                for (int i = 0; i < s.length() - 1; i++) {
                    char c = s.charAt(i);
                    char nextC = s.charAt(i + 1);
                    boolean currBig = true;
                    if (c - 'a' >= 0) {//小写
                        currBig = false;
                    }

                    boolean nextBig = true;
                    if (nextC - 'a' >= 0) {//小写
                        nextBig = false;
                    }
                    // 大小写不一致
                    if (currBig != nextBig && Math.abs(c - nextC) == 32) {
                        newStr = s.substring(0, i) + s.substring(i + 2);
                        break;
                    }
                }
                if (s.equals(newStr)) {
                    return newStr;
                }
                s = newStr;
            }
        }
    }

    class Solution2 {
        public char findKthBit(int n, int k) {
            char ans = 0;
            String preS = "0";
            String si = null;
            for (int i = 2; i <= n; i++) {
                si = preS + "1" + (reverse(invert(preS)));
                preS = si;
            }
            if (si == null) {
                si = preS;
            }
            return si.charAt(k - 1);
        }

        private String reverse(String s) {
            char[] array = s.toCharArray();
            char[] newArray = new char[s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                newArray[s.length() - 1 - i] = array[i];
            }
            return new String(newArray);
        }

        private String invert(String s) {
            StringBuilder sb = new StringBuilder();
            char[] array = s.toCharArray();
            for (char c : array) {
                if (c == '0') {
                    sb.append('1');
                }
                if (c == '1') {
                    sb.append('0');
                }
            }
            return sb.toString();
        }
    }
}
