package com.demo.lambda;


import com.demo.lambda.pojo.SomeThing;

/**
 * Description:
 * <p>
 * Create on 2019/08/01
 *
 * @author zys
 */
public class Test {

    public static void main(String[] args) {


        Converter<String, Integer> converter1 = (from) -> Integer.valueOf(from);
        Integer converted = converter1.converter("123");
        System.out.println(converted);

        SomeThing someThing = new SomeThing();
        Converter<String,String > converter = someThing::startsWith;
        String java = converter.converter("java");
        System.out.println(java);



    }
}
