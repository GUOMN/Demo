package com.guomn.lambda;

public class DemoTest {

    private FunctionInterfaceDemo 匿名内部类(){
        return new FunctionInterfaceDemo() {
            @Override
            public void test() {
                System.out.println("这是一个匿名内部类！");
            }
        };
    }

    private FunctionInterfaceDemo lambda(){
        return () -> System.out.println("这是lambda!");
    }

    private void testFunction(FunctionInterfaceDemo function){
        function.test();
    }

    public static void main(String[] args) {
        DemoTest demo = new DemoTest();
        demo.testFunction(demo.匿名内部类());
        demo.testFunction(demo.lambda());
    }
}
