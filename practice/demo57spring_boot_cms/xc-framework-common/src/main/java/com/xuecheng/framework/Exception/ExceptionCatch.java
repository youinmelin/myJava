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

@ControllerAdvice // 控制器增强
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    // 定义一个map,配置异常类型所对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS_MAP;
    // 定义一个map的builder对象,用来构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    @ExceptionHandler(CustomException.class)  // 捕获CustomException异常,可预知异常,由程序员抛出的异常
    @ResponseBody // 返回的是json字符串,没有这个注解会报404
    public ResponseResult customException(CustomException customException) {
        LOGGER.error("catch exception: {}", customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        ResponseResult responseResult = new ResponseResult(resultCode);
        return responseResult;
    }

    @ExceptionHandler(Exception.class)  // 捕获Exception异常,不可预知异常,由框架抛出的异常
    @ResponseBody // 返回的是json字符串,没有这个注解会报404
    public ResponseResult exception(Exception exception) {
        LOGGER.error("catch exception: {}", exception.getMessage());
        if (EXCEPTIONS_MAP == null) {
            EXCEPTIONS_MAP = builder.build();  // 用builder构建map, ImmutableMap一旦构建,不可改变
        }
        ResultCode resultCode = EXCEPTIONS_MAP.get(exception.getClass());
        if (resultCode == null) {
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
        return new ResponseResult(resultCode);
    }

    static {
        // 将制定的异常信息put进builder,用来构建map
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
    }

}

