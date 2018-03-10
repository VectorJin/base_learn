package com.jinku.demo.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinku on 2018/2/27.
 */
public class GenericTest<T, K, V> implements Serializable {

    public static <T> void main(String[] args, T type) {
        List<Object> list1 = new ArrayList();
        List<String> list2 = new ArrayList();

        if (list2 instanceof ArrayList<?>) {

        }

        List<? extends Number> list3 = new ArrayList<Integer>();
        List<? extends Number> list4 = new ArrayList<Float>();

        list3.add(null);


        List<? super Serializable> list5 = new ArrayList<Object>();

        list5.add(new GenericTest());
    }
}
