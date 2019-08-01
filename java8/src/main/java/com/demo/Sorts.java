package com.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Description:
 * <p>
 * Create on 2019/08/01
 *
 * @author zys
 */
public class Sorts {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        //匿名内部类
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

//        Collections.sort(names, (String a, String b) -> {
//            return a.compareTo(b);
//        });

        Collections.sort(names,(a,b) -> a.compareTo(b));

        for(String name : names){
            System.out.println(name);
        }
    }
}
