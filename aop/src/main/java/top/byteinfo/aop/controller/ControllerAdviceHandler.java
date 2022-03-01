package top.byteinfo.aop.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.byteinfo.aop.model.Result;


/**
 * 全局异常处理
 *
 * @author yezhqiu
 * @date 2021/06/11
 **/
@Log4j2
@RestControllerAdvice
public class ControllerAdviceHandler {

    /**
     * 处理服务异常
     *
     * @param e 异常
     * @return 接口异常信息
     */
    @ExceptionHandler(value = NullPointerException.class)
    public Result<?> errorHandler(RuntimeException e) {
      return   Result.builder().data(e.getMessage()).statusCode(500).build();
//        return Result.fail(e.getCode(), e.getMessage());

    }

//    /**
//     * 处理参数校验异常
//     *
//     * @param e 异常
//     * @return 接口异常信息
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Result<?> errorHandler(MethodArgumentNotValidException e) {
//        return Result.fail(VALID_ERROR.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
//    }
//
//    /**
//     * 处理系统异常
//     *
//     * @param e 异常
//     * @return 接口异常信息
//     */
//    @ExceptionHandler(value = Exception.class)
//    public Result<?> errorHandler(Exception e) {
//        e.printStackTrace();
//        return Result.fail(SYSTEM_ERROR.getCode(), SYSTEM_ERROR.getDesc());
//    }

}
