package com.rejulink.protocols.bean;

public class RequestCMSGetAccountInfoData {
    private String account;
    private String auth_code;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public RequestCMSGetAccountInfoData(String account, String auth_code) {
        super();
        this.account = account;
        this.auth_code = auth_code;
    }

}
