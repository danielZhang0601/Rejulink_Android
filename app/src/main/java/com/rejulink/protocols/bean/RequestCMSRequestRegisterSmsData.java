package com.rejulink.protocols.bean;

public class RequestCMSRequestRegisterSmsData {
    private String cellphone;

    public RequestCMSRequestRegisterSmsData(String cellphone) {
        super();
        this.cellphone = cellphone;
    }

    public String getCellphone() {
        return cellphone;
    }

}
