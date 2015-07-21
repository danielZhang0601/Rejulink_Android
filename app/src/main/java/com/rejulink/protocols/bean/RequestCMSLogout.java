package com.rejulink.protocols.bean;

public class RequestCMSLogout extends RequestJsonBase<RequestCMSLogoutData> {

    public RequestCMSLogout(RequestCMSLogoutData requestCMSLogoutData) {
        cmd = "logout";
        data = requestCMSLogoutData;
    }

}
