package com.jinku.demo.sort;

import java.util.Arrays;

/**
 * Created by jinku on 2018/3/8.
 */
public class MergeSort {

    public int[] sort(int[] origin) {
        if (origin == null || origin.length <= 1) {
            return origin;
        }
        int index = origin.length / 2;
        int[] array1 = Arrays.copyOfRange(origin, 0, index);
        int[] array2 = Arrays.copyOfRange(origin, index, origin.length);
        return mergeSort(array1, array2);
    }

    public int[] mergeSort(int[] array1, int[] array2) {
        if (array1.length == 0 && array2.length == 0) {
            return null;
        }
        if (array1.length == 1 && array2.length == 1) {
            int[] mergeArray = new int[2];
            if (array1[0] > array2[0]) {
                mergeArray[0] = array2[0];
                mergeArray[1] = array1[0];
            } else {
                mergeArray[0] = array1[0];
                mergeArray[1] = array2[0];
            }
            return mergeArray;
        }
        if (array1.length == 0 || array2.length == 0) {
            int[] mergeArray = new int[1];
            mergeArray[0] = array1.length == 0 ? array2[0] : array1[0];
            return mergeArray;
        }
        int index1 = array1.length / 2;
        int[] array11 = Arrays.copyOfRange(array1, 0, index1);
        int[] array12 = Arrays.copyOfRange(array1, index1, array1.length);

        int index2 = array2.length / 2;
        int[] array21 = Arrays.copyOfRange(array2, 0, index2);
        int[] array22 = Arrays.copyOfRange(array2, index2, array2.length);

        return mergeSortedArray(mergeSort(array11, array12), mergeSort(array21, array22));
    }

    public int[] mergeSortedArray(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }
        if (array1 == null) {
            return array2;
        }
        if (array2 == null) {
            return array1;
        }

        int length = 0;
        if (array1 != null) {
            length += array1.length;
        }
        if (array2 != null) {
            length += array2.length;
        }
        int[] array = new int[length];

        for (int i = 0; i < array1.length; i++) {
            array[i] = array1[i];
        }

        int start = 0;
        int curLength = array1.length;
        for (int i = 0; i < array2.length; i++) {
            boolean isInsert = false;
            for (int j = start; j < curLength; j++) {
                if (array2[i] < array[j]) {
                    // array[j]及之后的元素都后移一位
                    int index = j;
                    for (int k = curLength - 1; k >= j; k--) {
                        array[k + 1] = array[k];
                    }
                    array[index] = array2[i];
                    isInsert = true;
                    start = index;
                    curLength++;
                    break;
                }
            }

            // 放在现有元素后面
            if (!isInsert) {
                // 把剩下的全部放在后面
                for (int j = i; j < array2.length; j++) {
                    array[curLength] = array2[j];
                    curLength++;
                }
                break;
            }
        }
        return array;
    }
}
