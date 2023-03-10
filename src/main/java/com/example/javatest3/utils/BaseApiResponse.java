package com.example.javatest3.utils;

import cn.hutool.core.date.DateUtil;

public class BaseApiResponse {

    protected Integer code = 200;
    protected String errCode = "";
    protected String message;
    protected long timestamp;
    protected String time;

    public BaseApiResponse() {
        this.timestamp = System.currentTimeMillis();
        this.time = DateUtil.now();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
