package top.byteinfo.aops.apo1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description: AOP记录异常日志
 * @Author: Naccl
 * @Date: 2020-12-03
 */
@Component
@Aspect
public class ExceptionLogAspect {
//	@Autowired
//	ExceptionLogService exceptionLogService;

	/**
	 * 配置切入点
	 */
	@Pointcut("execution(* top.byteinfo.aops.apo1.controller..*.*(..))")
	public void logPointcut() {
	}

	@AfterThrowing(value = "logPointcut()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Exception e) {
//		ExceptionLog log = handleLog(joinPoint, e);
//		exceptionLogService.saveExceptionLog(log);
	}

	/**
	 * 设置ExceptionLog对象属性
	 *
	 * @return
	 */
//	private ExceptionLog handleLog(JoinPoint joinPoint, Exception e) {
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		String uri = request.getRequestURI();
//		String method = request.getMethod();
//		String ip = IpAddressUtils.getIpAddress(request);
//		String userAgent = request.getHeader("User-Agent");
//		//todo 使用swagger后，可以直接使用注解上的内容作为 ExceptionLog 的 description
//		String description = getDescriptionFromAnnotations(joinPoint);
//		String error = StringUtils.getStackTrace(e);
//		ExceptionLog log = new ExceptionLog(uri, method, description, error, ip, userAgent);
//		Map<String, Object> requestParams = AopUtils.getRequestParams(joinPoint);
//		log.setParam(StringUtils.substring(JacksonUtils.writeValueAsString(requestParams), 0, 2000));
//		return log;
//	}
//
//	private String getDescriptionFromAnnotations(JoinPoint joinPoint) {
//		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
//		OperationLogger operationLogger = method.getAnnotation(OperationLogger.class);
//		if (operationLogger != null) {
//			return operationLogger.value();
//		}
//		VisitLogger visitLogger = method.getAnnotation(VisitLogger.class);
//		if (visitLogger != null) {
//			return visitLogger.value().getBehavior();
//		}
//		return "";
//	}
}