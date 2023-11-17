package GSF.Example.Log;

public class CustomLogClass {
    public void before(){
        System.out.println("---------基于XML自定义类方式实现，前置通知:方法执行前---------");
    }

    public void after(){
        System.out.println("---------基于XML自定义类方式实现，后置通知:方法执行前---------");
    }
}
