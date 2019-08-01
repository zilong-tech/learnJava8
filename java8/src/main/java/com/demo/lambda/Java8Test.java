package com.demo.lambda;

/**
 * Description:
 * <p>
 * Create on 2019/08/01
 *
 * @author zys
 */
public class Java8Test {

    public static void main(String[] args) {


        //类型声明
        MathOperation addOperation = (int a,int b) -> a + b;

        //不用类型声明
        MathOperation subOperation = (a,b) -> a - b;

        // 有大括号，有return 关键字
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号没有return 关键字
        MathOperation division = (int a, int b) -> a / b;


        System.out.println("10 + 5 = " + Java8Test.operate(10,5,addOperation));

        System.out.println("10 - 5 = " + Java8Test.operate(10,5,subOperation));

        System.out.println("10 x 5 = " + Java8Test.operate(10, 5, multiplication));

        System.out.println("10 / 5 = " + Java8Test.operate(10, 5, division));

        // 参数不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 参数用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");



    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private static int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
