package com.easy.day9.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);

    }




    @Test
    public void testGeneric() throws Exception {
        List list = new ArrayList();
        list.add("china");
        list.add(1);

        //集合的使用
        String str = (String) list.get(0);

    }
}
