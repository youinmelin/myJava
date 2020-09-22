package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * 抛出异常的类，负责接受错误代码，抛出
 */
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException((resultCode));
    }
}
