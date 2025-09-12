package com.easy.day6;

import org.junit.Test;

import java.util.*;

public class ConnectionDemo {
    @Test
    public void test1() {
        //数组最大问题是长度固定，而且要操作下标
        Student[] array = new Student[3];

        ArrayList<Student> list = new ArrayList<>();
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        for (Student student : list) {
            System.out.println(student);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-------------------");

        //有序可重复
        //有序：你放进去的顺序和拿出来的顺序一致
        //ArrayList<String> list1 = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("Java");
        list1.add("UI");
        list1.add("H5");
        list1.add("H5");
        list1.add("aa");
        for (String str : list1) {
            System.out.println(str);
        }
        System.out.println("-------------------");
        //无序不重复
        //无序：放进去顺序和拿出来的顺序可能是不一致的
        //HashSet<String> set = new HashSet<String>();
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("UI");
        set.add("H5");
        set.add("H5");
        set.add("aa");
        for (String str : set) {
            System.out.println(str);
        }
    }

    @Test
    public void test55() {
        Map<String, String> map = new HashMap<>();
        map.put("cn", "中国");
        map.put("us", "美国");
        map.put("uk", "英国");
        String country = map.get("cn");
        System.out.println(country);

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("----------------");
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("-----------------");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + map.get(key));
        }
        System.out.println("-----------------");

    }
}
