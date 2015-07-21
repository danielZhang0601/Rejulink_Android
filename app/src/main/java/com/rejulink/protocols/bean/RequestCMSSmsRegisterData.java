package com.rejulink.protocols.bean;

public class RequestCMSSmsRegisterData {
    private String account;
    private String password;
    private String sms_code;

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getSms_code() {
        return sms_code;
    }

    public RequestCMSSmsRegisterData(String account, String password,
                                     String sms_code) {
        super();
        this.account = account;
        this.password = password;
        this.sms_code = sms_code;
    }

}
