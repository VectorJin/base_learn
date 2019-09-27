package com.jinku.learn.sort;

/**
 * Created by jinku on 2018/3/2.
 */
public class SortTest {

    public static void main(String[] args) {
        int[] origin = {-1, 100, 8, 9, 10, 3, 4, 2, 1, 11};

//        QuickSort quickSort = new QuickSort();
//        quickSort.sort(origin, 0, origin.length -1);

//        InsertSort insertSort = new InsertSort();
//        insertSort.sort(origin);

//        SelectSort selectSort = new SelectSort();
//        selectSort.sort(origin);

//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(origin);

        MergeSort mergeSort = new MergeSort();
        origin = mergeSort.sort(origin);

        for (int i = 0; i < origin.length; i++) {
            System.out.print(origin[i] + " ");
        }

    }
}
