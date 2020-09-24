package com.xuecheng.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 统一的异常捕获类
 */
@ControllerAdvice  // 控制器增强注解,想要被spring boot扫描到,需要在启动器上加扫描注解
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    // 定义map,配置异常类型所对应的错误代码 Class<? extends Throwable>: 异常类
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    // 定义map的builder对象,用来构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    // 捕获CustomException此类异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException) {
        // 记录日志
        LOGGER.error("catch execption:{}", customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult sysExecption(Exception exception){
        // 记录日志
        LOGGER.error("catch execption:{}", exception.getMessage());
        System.out.println(exception.getMessage());
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();  // EXCEPTIONS构建成功
        }
        // 从EXECPTIONS类中找异常类型所对应的错误代码,如果找到了就将错误代码响应给前端,如果找不到则响应99999
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode !=  null) {
            return new ResponseResult(resultCode);
        }else {
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }

    }

    static {
        // 定义异常类型所对应的错误代码HttpMessageNotReadableException,保存到map中
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);

    }
}
