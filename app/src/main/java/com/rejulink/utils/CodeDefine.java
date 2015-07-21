package com.rejulink.utils;

public class CodeDefine {

    /**
     * 服务器返回定义
     */
    //	0	操作成功
    public static final int SUCCESS_DONE = 0;
    //	1	未知错误
    public static final int ERROR_UNKNOWN = 1;
    //	2	服务器繁忙
    public static final int ERROR_SERVE_BUSY = 2;
    //	3 参数错误
    public static final int ERROR_INVALID_PARAMS = 3;
    //	100	用户名格式不正确
    public static final int ERROR_INVALID_ACCOUNT = 100;
    //	101	密码格式不正确
    public static final int ERROR_INVALID_PASSWORD = 101;
    //	102	手机号码格式不正确
    public static final int ERROR_INVALID_CELLPHONE = 102;
    //	103	邮箱格式不正确
    public static final int ERROR_INVALID_EMAIL = 103;
    //	104	授权码格式不正确
    public static final int ERROR_INVALID_AUTH_CODE = 104;
    //	105	设备序列号格式不正确

    //	200	邮箱未认证
    //	201	邮箱验证码未通过
    //	202	短信验证码未通过
    //	203	图片验证码未通过
    //	204	权限认证不通过
    //	300	用户已存在
    //	301	用户名不存在
    //	302	用户未登陆
    //	303	密码错误
    //	304	该手机号码已被其他用户绑定
    //	305	该邮箱已被其他用户绑定
    //	306	新密码和旧密码不能相同
    //	307	新手机号码和旧手机号码不能相同
    //	308	新邮箱和旧邮箱不能相同
    //	309	该手机号码已经被使用
    //	310	该邮箱已经被使用
}
