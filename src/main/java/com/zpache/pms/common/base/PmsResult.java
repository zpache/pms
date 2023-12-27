package com.zpache.pms.common.base;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 11:07
 */
public class PmsResult<T> {
    protected String code;
    protected String message;
    protected T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
