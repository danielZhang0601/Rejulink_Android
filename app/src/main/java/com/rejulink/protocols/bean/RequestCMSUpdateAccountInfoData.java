package com.rejulink.protocols.bean;

public class RequestCMSUpdateAccountInfoData {
    private String account;
    private String auth_code;
    private String nick_name;
    private int sex;
    private String address;
    private String birthday;

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

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public RequestCMSUpdateAccountInfoData(String account, String auth_code,
                                           String nick_name, int sex, String address, String birthday) {
        super();
        this.account = account;
        this.auth_code = auth_code;
        this.nick_name = nick_name;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
    }

}
