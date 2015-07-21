package com.rejulink.protocols.bean;

public class RequestCMSConfirmModifyCellphone extends
        RequestJsonBase<RequestCMSConfirmModifyCellphoneData> {

    public RequestCMSConfirmModifyCellphone(
            RequestCMSConfirmModifyCellphoneData requestCMSConfirmModifyCellphoneData) {
        cmd = "confirm_modify_cellphone";
        data = requestCMSConfirmModifyCellphoneData;
    }

}
