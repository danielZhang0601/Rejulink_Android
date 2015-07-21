package com.rejulink.protocols.bean;

public class RequestCMSRequestResetPasswordByPhone extends RequestJsonBase<RequestCMSRequestResetPasswordByPhoneData> {

    public RequestCMSRequestResetPasswordByPhone(
            RequestCMSRequestResetPasswordByPhoneData requestCMSRequestResetPasswordByPhoneData) {
        cmd = "request_reset_password_by_phone";
        data = requestCMSRequestResetPasswordByPhoneData;
    }

}
