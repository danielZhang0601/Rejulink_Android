package com.rejulink.protocols.bean;

public class RequestCMSRequestRegisterSms extends
        RequestJsonBase<RequestCMSRequestRegisterSmsData> {

    public RequestCMSRequestRegisterSms(
            RequestCMSRequestRegisterSmsData requestCMSRequestRegisterSmsData) {
        cmd = "request_register_sms";
        data = requestCMSRequestRegisterSmsData;
    }

}
