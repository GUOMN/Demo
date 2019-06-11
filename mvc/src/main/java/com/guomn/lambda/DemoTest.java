package com.guomn.lambda;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class DemoTest {

    private static FunctionInterfaceDemo 匿名内部类(){
        return new FunctionInterfaceDemo() {
            @Override
            public void test() {
                System.out.println("这是一个匿名内部类！");
            }
        };
    }

    private static FunctionInterfaceDemo lambda(){
        return () -> System.out.println("这是lambda!");
    }

    private static void testFunction(FunctionInterfaceDemo function){
        function.test();
    }

    /**
     * Supplier的用法
     */
    private static void testSuppliser(Supplier<String> supplier){
        System.out.println(supplier.get());
    }

    /**
     * Predicate的用法
     */
    private static void testPredicate(String param){
        Predicate<String> predicate = s -> s.equals("aaa");
        System.out.println(predicate.test(param));
    }


    public static void main(String[] args) {
        testFunction(匿名内部类());
        testFunction(lambda());

        testSuppliser(() -> "this is a suppliser demo");
        testPredicate("aaa");

    }
}
