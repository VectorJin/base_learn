package com.jinku.learn.leetcode;

/**
 * 模式匹配
 */
public class Num1618 {

    public static void main(String[] args) {
        System.out.println(patternMatching("abbab", "dogcatcatdog"));
    }

    public static boolean patternMatching(String pattern, String value) {
        if (pattern == null || value == null) {
            return false;
        }

        int aNum = 0;
        int bNum = 0;

        for (char c : pattern.toCharArray()) {
            if (c == 'a') {
                aNum++;
            }
            if (c == 'b') {
                bNum++;
            }
        }

        if (value.length() == 0) {
            return aNum == 0 || bNum == 0;
        }

        // 暴力a的长度
        for (int aLength = 0; aLength <= value.length(); aLength++) {
            // 计算b的长度
            int bStrLength = value.length() - (aNum * aLength);
            if (bStrLength < 0) {
                continue;
            }
            int bLength = 0;
            if (bNum == 0) {
                if (bStrLength != 0) {
                    continue;
                }
            } else {
                if (bStrLength % bNum != 0) {
                    continue;
                }
                bLength = bStrLength / bNum;
            }

            // 计算a 和 b的内容
            String aString = null;
            String bString = null;
            if (aLength == 0) {
                aString = "";
            }
            if (bLength == 0) {
                bString = "";
            }
            int offset = 0;
            for (char c : pattern.toCharArray()) {
                if (aString != null && bString != null) {
                    break;
                }
                if (c == 'a') {
                    if (aString == null) {
                        aString = value.substring(offset, offset + aLength);
                    }
                    offset += aLength;
                }

                if (c == 'b') {
                    if (bString == null) {
                        bString = value.substring(offset, offset + bLength);
                    }
                    offset += bLength;
                }
            }

            aString = aString == null ? "" : aString;
            bString = bString == null ? "" : bString;

            if (aString.equals(bString)) {
                return false;
            }

            // 匹配模式内容
            String expectValue = "";
            for (char c : pattern.toCharArray()) {
                if (c == 'a') {
                    expectValue += aString;
                }

                if (c == 'b') {
                    expectValue += bString;
                }
            }
            if (value.equals(expectValue)) {
                return true;
            }
        }
        return false;
    }
}
