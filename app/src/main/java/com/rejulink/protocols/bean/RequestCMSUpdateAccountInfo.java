package com.rejulink.protocols.bean;

public class RequestCMSUpdateAccountInfo extends
        RequestJsonBase<RequestCMSUpdateAccountInfoData> {

    public RequestCMSUpdateAccountInfo(
            RequestCMSUpdateAccountInfoData requestCMSUpdateAccountInfoData) {
        cmd = "update_account_info";
        data = requestCMSUpdateAccountInfoData;
    }

}
