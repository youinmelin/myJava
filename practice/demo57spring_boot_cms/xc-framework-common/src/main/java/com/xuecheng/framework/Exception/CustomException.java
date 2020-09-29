package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

// 自定义异常类,定义错误代码,创建对象时由构造方法获取错误代码,外部可以通过getter方法获取错误代码
public class CustomException extends RuntimeException{

    private ResultCode resultCode;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
