package com.rejulink.protocols.bean;

public class RequestCMSRequestResetPasswordByPhoneData {
    private String account;

    public RequestCMSRequestResetPasswordByPhoneData(String account) {
        super();
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
