package top.byteinfo.aops.aop0.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class ControllerAop {


    @Pointcut("execution(public * top.byteinfo.aops.aop0.controller..*.*(..))")
    public void controllerLog() {
    }

    @Around("controllerLog()")
    public Object Find(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();
        Class<?> declaringClass = method.getDeclaringClass();
        String name = method.getName();
        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        int parameterCount = method.getParameterCount();

        Class returnType = signature.getReturnType();

        log.info("++++++++++++++++++++++++++");
        log.info(declaringClass.getName());
        log.info(name);
        log.info("++++++++++++++++++++++++++");

        Object result = null;
        result = joinPoint.proceed();


        return result;
    }
}
