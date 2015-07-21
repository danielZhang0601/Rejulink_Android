package com.rejulink.protocols.bean;

public class RequestCMSConfirmModifyCellphoneData {
    private String auth_code;
    private String account;
    private String password;
    private String new_phone;

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
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

    public String getNew_phone() {
        return new_phone;
    }

    public void setNew_phone(String new_phone) {
        this.new_phone = new_phone;
    }

    public RequestCMSConfirmModifyCellphoneData(String auth_code,
                                                String account, String password, String new_phone) {
        super();
        this.auth_code = auth_code;
        this.account = account;
        this.password = password;
        this.new_phone = new_phone;
    }

}
