package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.CommonCode;

public class test {
    public static void main(String[] args) {
        System.out.println(CommonCode.valueOf("SUCCESS"));
        CommonCode code = CommonCode.SUCCESS;
        System.out.println(code);
    }
}
