package com.rejulink.protocols.bean;

public class RequestCMSLogin extends RequestJsonBase<RequestCMSLoginData> {

    public RequestCMSLogin(RequestCMSLoginData requestCMSLoginData) {
        cmd = "login";
        data = requestCMSLoginData;
    }

}
