package com.rejulink.protocols.bean;

public class RequestCMSModifyPassword extends
        RequestJsonBase<RequestCMSModifyPasswordData> {

    public RequestCMSModifyPassword(
            RequestCMSModifyPasswordData requestCMSModifyPasswordData) {
        cmd = "modify_password";
        data = requestCMSModifyPasswordData;
    }

}
