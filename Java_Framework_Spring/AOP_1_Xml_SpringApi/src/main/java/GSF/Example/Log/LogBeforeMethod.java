package GSF.Example.Log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogBeforeMethod implements MethodBeforeAdvice {
    /***
     *
     * @param method 要执行的目标对象（UserServiceImpl）的方法
     * @param args 被调用的方法的参数
     * @param target 目标对象（UserServiceImpl）
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AOP前置通知：" + "在" + target.getClass().getName() + "的" + method.getName() + "方法调用前执行。目标对象-方法-参数，都可以获取到");
    }
}
