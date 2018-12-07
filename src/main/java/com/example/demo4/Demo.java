package com.example.demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description TODO
 * @Author caiwo
 * @Date 2018/11/21 20:20
 */
public class Demo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("d");
        list.add("c");
        list.forEach(s -> {
            System.out.println(s);
        });
        for (String s : list) {
            System.out.println(s);
        }
    }
}
