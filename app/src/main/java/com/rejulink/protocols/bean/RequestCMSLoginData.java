package com.rejulink.protocols.bean;

public class RequestCMSLoginData {
    private String account;
    private String password;
    private String verify_code;

    public RequestCMSLoginData(String account, String password,
                               String verify_code) {
        super();
        this.account = account;
        this.password = password;
        this.verify_code = verify_code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

}
