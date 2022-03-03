package top.byteinfo.aops.aop0.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
@Order(0)
public class FindAop {
    @Pointcut("execution(public * top.byteinfo.aops.aop0.controller..*.*(..))")
    public void findPackage() {

    }

    @Around("findPackage()")
    public Object FindClass(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        String name = method.getName();
        Object result = null;

        log.info("++++++++++++++++++++++++++");
        log.info("++++++++++++++++++++++++++");

        log.info(declaringClass.getName());
        log.info(declaringClass.getName());
        log.info(name);
        log.info("---------------------------");
        log.info("---------------------------");

        result = proceedingJoinPoint.proceed();
        return result;
    }

}
