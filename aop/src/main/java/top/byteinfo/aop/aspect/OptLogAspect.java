package top.byteinfo.aop.aspect;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import top.byteinfo.aop.annotation.OptLog;
import top.byteinfo.aop.entity.OperationLog;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 操作日志切面处理
 *
 * @author yezhiqiu
 * @date 2021/07/27
 */
@Aspect
@Component
@Slf4j
public class OptLogAspect {

//    @Autowired
//    private OperationLogDao operationLogDao;

    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(top.byteinfo.aop.annotation.OptLog)")
    public void optLogPointCut() {
    }


    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint 切入点
     * @param keys      返回结果
     */
    @AfterReturning(value = "optLogPointCut()", returning = "keys")
    public void saveOptLog(JoinPoint joinPoint, Object keys) {
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(requestAttributes).resolveReference(RequestAttributes.REFERENCE_REQUEST);
        OperationLog operationLog = new OperationLog();
        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在的方法
        Method method = signature.getMethod();
        // 获取操作
        Api api = (Api) signature.getDeclaringType().getAnnotation(Api.class);
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        OptLog optLog = method.getAnnotation(OptLog.class);
//        // 操作模块
//        operationLog.setOptModule(api.tags()[0]);
//        // 操作类型
//        operationLog.setOptType(optLog.optType());
//        // 操作描述
//        operationLog.setOptDesc(apiOperation.value());
        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求的方法名
        String methodName = method.getName();
        methodName = className + "." + methodName;

        String name = joinPoint.getTarget().getClass().getName();
        log.info(name);
        Object[] args = joinPoint.getArgs();
//        String s = JSON.toJSONString(args);
//        log.info(s);

        // attention !!!
        assert request != null;
        String requestMethod = request.getMethod();
        log.info(requestMethod);


        String[] tags = api.tags();
        log.info(tags.toString());


//        String value = apiOperation.value();
        if (apiOperation.value() == null) {

        }
        operationLog.setIpAddress(Objects.requireNonNull(apiOperation.value()));


        String optType = optLog.optType();
        log.info(optType);


//        // 请求方式
//        operationLog.setRequestMethod(Objects.requireNonNull(request).getMethod());
//        // 请求方法
//        operationLog.setOptMethod(methodName);
//        // 请求参数
//        operationLog.setRequestParam(JSON.toJSONString(joinPoint.getArgs()));
//        // 返回结果
//        operationLog.setResponseData(JSON.toJSONString(keys));
//        // 请求用户ID
//        operationLog.setUserId(UserUtils.getLoginUser().getId());
//        // 请求用户
//        operationLog.setNickname(UserUtils.getLoginUser().getNickname());
//        // 请求IP
        //TODO
//        String ipAddress = IpUtils.getIpAddress(request);
//        operationLog.setIpAddress(ipAddress);
//        operationLog.setIpSource(IpUtils.getIpSource(ipAddress));
//        // 请求URL
//        operationLog.setOptUrl(request.getRequestURI());
//        operationLogDao.insert(operationLog);
    }

}
