package com.rejulink.protocols.bean;

public class RequestCMSGetAccountInfo extends
        RequestJsonBase<RequestCMSGetAccountInfoData> {

    public RequestCMSGetAccountInfo(
            RequestCMSGetAccountInfoData requestCMSGetAccountInfoData) {
        cmd = "get_account_info";
        data = requestCMSGetAccountInfoData;
    }

}
