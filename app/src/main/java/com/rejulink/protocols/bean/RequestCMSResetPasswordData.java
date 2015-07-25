package com.rejulink.protocols.bean;

public class RequestCMSResetPasswordData {
    private String account;
    private String new_password;
    private String reset_code;

    public RequestCMSResetPasswordData(String account, String new_password,
                                       String reset_code) {
        super();
        this.account = account;
        this.new_password = new_password;
        this.reset_code = reset_code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getReset_code() {
        return reset_code;
    }

    public void setReset_code(String reset_code) {
        this.reset_code = reset_code;
    }

}
