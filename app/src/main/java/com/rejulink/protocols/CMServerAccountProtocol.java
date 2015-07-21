package com.rejulink.protocols;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.rejulink.networks.ZAsyncHttpClient;
import com.rejulink.protocols.bean.*;

public class CMServerAccountProtocol {

//    public static String BASE_URL = "http://192.168.8.107:8080";

//    public static String BASE_URL = "http://192.168.8.150:3000";

    public static String BASE_URL = "http://120.25.250.154";

    public static String API_ACCOUNT = BASE_URL + "/api/account";

    public static String UTILS_HELLO = BASE_URL + "/hello.html";

    /**
     * 向服务器发送测试请求 用于获取SessionId
     *
     * @param context         上下文
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void test(Context context, AsyncHttpResponseHandler responseHandler) {
        ZAsyncHttpClient.get(context, UTILS_HELLO, responseHandler);
    }

    /**
     * 向CMS发送登录请求
     *
     * @param context         上下文
     * @param account         账号
     * @param password        密码
     * @param verify_code     验证码 手机可能不需要
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void login(Context context, String account, String password, String verify_code, AsyncHttpResponseHandler responseHandler) {
        RequestCMSLogin reqLogin = new RequestCMSLogin(new RequestCMSLoginData(account, password, verify_code));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqLogin), responseHandler);
    }

    /**
     * 向CMS发送请求注册短信验证码请求
     *
     * @param context         上下文
     * @param cellphone       手机号
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void request_register_sms(Context context, String cellphone, AsyncHttpResponseHandler responseHandler) {
        RequestCMSRequestRegisterSms reqRequestRegisterSms = new RequestCMSRequestRegisterSms(new RequestCMSRequestRegisterSmsData(cellphone));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqRequestRegisterSms), responseHandler);
    }

    /**
     * 向CMS发送短信注册请求
     *
     * @param context         上下文
     * @param account         账号
     * @param password        密码
     * @param sms_code        短信验证码
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void sms_register(Context context, String account, String password, String sms_code, AsyncHttpResponseHandler responseHandler) {
        RequestCMSSmsRegister reqSmsRegister = new RequestCMSSmsRegister(new RequestCMSSmsRegisterData(account, password, sms_code));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqSmsRegister), responseHandler);
    }

    /**
     * 向CMS发送注销请求
     *
     * @param context         上下文
     * @param account         账号
     * @param auth_code       登录获得的校验码
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void logout(Context context, String account, String auth_code, AsyncHttpResponseHandler responseHandler) {
        RequestCMSLogout reqLogout = new RequestCMSLogout(new RequestCMSLogoutData(account, auth_code));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqLogout), responseHandler);
    }

    /**
     * 向CMS发送修改密码请求
     *
     * @param context         上下文
     * @param account         账号
     * @param old_password    旧密码
     * @param new_password    新密码
     * @param auth_code       登录获得的校验码
     * @param verify_code     校验码 手机端可能不需要
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void modify_password(Context context, String account, String old_password, String new_password, String auth_code, String verify_code, AsyncHttpResponseHandler responseHandler) {
        RequestCMSModifyPassword reqCmsModifyPassword = new RequestCMSModifyPassword(new RequestCMSModifyPasswordData(auth_code, account, old_password, new_password, verify_code));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqCmsModifyPassword), responseHandler);
    }

    /**
     * 向CMS发送获取重置密码验证码请求
     *
     * @param context         上下文
     * @param account         账号
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void request_reset_password_by_phone(Context context, String account, AsyncHttpResponseHandler responseHandler) {
        RequestCMSRequestResetPasswordByPhone reqResetPasswordByPhone = new RequestCMSRequestResetPasswordByPhone(new RequestCMSRequestResetPasswordByPhoneData(account));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqResetPasswordByPhone), responseHandler);
    }

    /**
     * 向CMS发送重置密码请求
     *
     * @param context         上下文
     * @param account         账号
     * @param new_password    新密码
     * @param reset_code      重置验证码
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void reset_password(Context context, String account, String new_password, String reset_code, AsyncHttpResponseHandler responseHandler) {
        RequestCMSResetPassword reqResetPassword = new RequestCMSResetPassword(new RequestCMSResetPasswordData(account, new_password, reset_code));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqResetPassword), responseHandler);
    }

    /**
     * 向CMS发送获取修改手机号验证码请求
     *
     * @param context         上下文
     * @param auth_code       登录返回的校验码
     * @param account         账号
     * @param password        密码
     * @param new_phone       新手机号
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void request_modify_cellphone(Context context, String auth_code, String account, String password, String new_phone, AsyncHttpResponseHandler responseHandler) {
        RequestCMSRequestModifyCellphone reqRequestModifyCellphone = new RequestCMSRequestModifyCellphone(new RequestCMSRequestModifyCellphoneData(auth_code, account, password, new_phone));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqRequestModifyCellphone), responseHandler);
    }

    /**
     * 向CMS发送确认修改手机号请求
     *
     * @param context         上下文
     * @param auth_code       登录返回校验码
     * @param account         账号
     * @param password        密码
     * @param new_phone       新手机号
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void confirm_modify_cellphone(Context context, String auth_code, String account, String password, String new_phone, AsyncHttpResponseHandler responseHandler) {
        RequestCMSConfirmModifyCellphone reqConfirmModifyCellphone = new RequestCMSConfirmModifyCellphone(new RequestCMSConfirmModifyCellphoneData(auth_code, account, password, new_phone));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqConfirmModifyCellphone), responseHandler);
    }

    /**
     * 向CMS发送获取用户信息请求
     *
     * @param context         上下文
     * @param account         账号
     * @param auth_code       登录获得的校验码
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void get_account_info(Context context, String account, String auth_code, AsyncHttpResponseHandler responseHandler) {
        RequestCMSGetAccountInfo reqGetAccountInfo = new RequestCMSGetAccountInfo(new RequestCMSGetAccountInfoData(account, auth_code));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqGetAccountInfo), responseHandler);
    }

    /**
     * 向CMS发送更新用户信息请求
     *
     * @param context         上下文
     * @param account         账号
     * @param auth_code       登录获得的校验码
     * @param nick_name       昵称
     * @param sex             性别
     * @param address         住址
     * @param birthday        生日
     * @param responseHandler 网络请求返回数据解析Handler
     */
    public static void update_account_info(Context context, String account, String auth_code, String nick_name, int sex, String address, String birthday, AsyncHttpResponseHandler responseHandler) {
        RequestCMSUpdateAccountInfo reqUpdateAccountInfo = new RequestCMSUpdateAccountInfo(new RequestCMSUpdateAccountInfoData(account, auth_code, nick_name, sex, address, birthday));
        ZAsyncHttpClient.post(context, API_ACCOUNT, JSON.toJSONString(reqUpdateAccountInfo), responseHandler);
    }

}
