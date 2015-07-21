package com.rejulink.protocols.bean;

public class RequestCMSResetPassword extends
        RequestJsonBase<RequestCMSResetPasswordData> {

    public RequestCMSResetPassword(
            RequestCMSResetPasswordData requestCMSResetPasswordData) {
        cmd = "reset_password";
        data = requestCMSResetPasswordData;
    }

}
