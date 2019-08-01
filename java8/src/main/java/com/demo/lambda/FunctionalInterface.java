package com.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Description:
 * <p>
 * Create on 2019/08/01
 *
 * @author zys
 */
public class FunctionalInterface {

    public static void main(String[] args) {

        //1、Predicate默认实现的方法and，or，negate，isEqual ,这四个方法对应了java的三个连接符号&&、||、!、==

        Predicate<String> predicate = (s) -> s.length() > 1;

        System.out.println(predicate.test("f"));
        System.out.println(predicate.negate().test("foo"));

        Predicate<Boolean> p = Objects::isNull;
        System.out.println(p.test(null));


        int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<Integer> list=new ArrayList<>();
        for(int i:numbers) {
            list.add(i);
        }
        Predicate<Integer> p1=i->i>5;
        Predicate<Integer> p2=i->i<20;
        Predicate<Integer> p3=i->i%2==0;

        List test=list.stream().filter(p1.and(p2).and(p3)).collect(Collectors.toList());
        System.out.println(test.toString());

        List test1=list.stream().filter(p1.and(p2).and(p3.negate())).collect(Collectors.toList());
        System.out.println(test1.toString());

        List test2=list.stream()
                .filter(p1.and(p2).and(p3.negate()).and(Predicate.isEqual(7)))
                .collect(Collectors.toList());
        System.out.println(test2);

        //2、Function apply,compose和andThen
        Function<Integer,Integer> test3=i->i+1;
        Function<Integer,Integer> test4=i->i*i;
        System.out.println(calculate(test3,5)); //6
        System.out.println(calculate(test4,5)); //25

        Function<Integer,Integer> A=i->i+1;
        Function<Integer,Integer> B=i->i*i;
        //compose等价于B.apply(A.apply(5))，而andThen等价于A.apply(B.apply(5))
        System.out.println("F1:"+B.apply(A.apply(5))); //F1:36
        System.out.println("F1:"+B.compose(A).apply(5)); //F1:36
        System.out.println("F2:"+A.apply(B.apply(5))); //F2:26
        System.out.println("F2:"+B.andThen(A).apply(5)); //F2:26


    }

    public static Integer calculate(Function<Integer,Integer> test,Integer number){

        return test.apply(number);
    }
}
