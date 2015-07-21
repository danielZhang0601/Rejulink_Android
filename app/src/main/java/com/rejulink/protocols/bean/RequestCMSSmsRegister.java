package com.rejulink.protocols.bean;

public class RequestCMSSmsRegister extends
        RequestJsonBase<RequestCMSSmsRegisterData> {

    public RequestCMSSmsRegister(
            RequestCMSSmsRegisterData requestCMSSmsRegisterData) {
        cmd = "sms_register";
        data = requestCMSSmsRegisterData;
    }

}
