package GSF.Example.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationClass {
    @Before("execution(* GSF.Example.Service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("---------基于注解方式实现，前置通知:方法执行前---------");
    }

    @After("execution(* GSF.Example.Service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("---------基于注解方式实现，后置通知：方法执行后---------");
    }

    @Around("execution(* GSF.Example.Service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("环绕通知：环绕前");
        System.out.println(jp.getSignature());

        // 执行目标方法
        Object proceed = jp.proceed();
        System.out.println(proceed);

        System.out.println("环绕通知：环绕后");
    }

}
