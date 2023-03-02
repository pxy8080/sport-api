package com.pxy.yigou.entity;

public class ResultUtil {
    public static <T> Result<T>  defineSuccess(Integer code, T data) {
        Result result = new Result<>();
        return result.setCode(code).setresult(data);
    }

    public static <T> Result<T> success(T data,String msg) {
        Result result = new Result();
        result.setmessage(msg);
        result.setCode(ResultEnum.SUCCESS).setresult(data);
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result result = new Result();
        result.setCode(ResultEnum.FAIL).setmessage(msg);
        return result;
    }

    public static <T> Result<T> defineFail(int code, String msg){
        Result result = new Result();
        result.setCode(code).setmessage(msg);
        return result;
    }

    public static <T> Result<T> define(int code, String msg, T data){
        Result result = new Result();
        result.setCode(code).setmessage(msg).setresult(data);
        return result;
    }
}
