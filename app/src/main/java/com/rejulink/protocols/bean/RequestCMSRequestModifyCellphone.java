package com.rejulink.protocols.bean;

public class RequestCMSRequestModifyCellphone extends
        RequestJsonBase<RequestCMSRequestModifyCellphoneData> {

    public RequestCMSRequestModifyCellphone(
            RequestCMSRequestModifyCellphoneData requestCMSRequestModifyCellphoneData) {
        cmd = "request_modify_cellphone";
        data = requestCMSRequestModifyCellphoneData;
    }

}
