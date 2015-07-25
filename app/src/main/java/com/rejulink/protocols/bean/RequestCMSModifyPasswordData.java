package com.rejulink.protocols.bean;

public class RequestCMSModifyPasswordData {
    private String auth_code;
    private String account;
    private String old_password;
    private String new_password;
    private String verify_code;

    public RequestCMSModifyPasswordData(String auth_code, String account,
                                        String old_password, String new_password, String verify_code) {
        super();
        this.auth_code = auth_code;
        this.account = account;
        this.old_password = old_password;
        this.new_password = new_password;
        this.verify_code = verify_code;
    }

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

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

}
