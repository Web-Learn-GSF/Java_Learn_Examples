package GSF.Example.Log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LogAfterMethod implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AOP后置通知：" + "在" + target.getClass().getName() + "的" + method.getName() + "方法调用后执行。目标对象-方法-参数，都可以获取到");
    }
}
