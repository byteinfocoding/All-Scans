package top.byteinfo.aop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result<T>{
    private Boolean flag;
    private Integer statusCode;
    private String message;
    private T data;



}