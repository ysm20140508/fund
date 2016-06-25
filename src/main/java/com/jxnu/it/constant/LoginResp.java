package com.jxnu.it.constant;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginResp {
    private int result;
    private String msg;
    private String url;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
        this.msg = Result.getMsg(result);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("result", result)
                .append("msg", msg)
                .append("url", url)
                .toString();
    }
}
