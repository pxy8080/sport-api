package com.pxy.yigou.entity;

public class Result<T> {
    private Integer code;
    private String message;
    private T result;

    public Result() {
    }

    public Result(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getmessage() {
        return message;
    }

    public Result setmessage(String message) {
        this.message = message;
        return this;
    }

    public T getresult() {
        return result;
    }

    public Result setresult(T result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    public Result setCode(ResultEnum resultEnum) {
        this.code = resultEnum.code;
        return this;
    }
}
