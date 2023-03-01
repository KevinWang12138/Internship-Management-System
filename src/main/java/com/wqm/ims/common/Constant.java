package com.wqm.ims.common;

public class Constant {
    /**
     * 错误码
     */
    //基本错误
    public static final int commonErrorNo = 1001;
    public static final int paramErrorNo = 1002;
    //登录系统错误
    public static final int loginErrorNo = 2001;
    public static final int phoneErrorNo = 2002;
    public static final int phoneNotExistErrorNo = 2003;
    public static final int passwordErrorNo = 2004;
    /**
     * 错误信息
     */
    public static final String commonErrorMsg = "系统错误，请稍后重试";
    public static final String paramErrorMsg = "参数不能为空，请检查输入";
    public static final String loginErrorMsg = "用户名或密码错误，请重试";
    public static final String phoneErrorMsg = "手机号格式错误，请输入正确的手机号";
    public static final String phoneNotExistErrorMsg = "手机号不存在，请注册";
    public static final String passwordErrorMsg = "密码输入错误，请重试";
}
