package com.rejulink.protocols.bean;

public abstract class RequestJsonBase<T> {
    protected String cmd;
    protected T data;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
