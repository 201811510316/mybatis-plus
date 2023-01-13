package com.example.javatest3.common;

import lombok.Data;

@Data
public class response<T> {
    private Integer code;
    private String message;
    private T object;

    public response() {
    }

    public response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public response(Integer code, String message, T object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public static <T> response<T> success(T object){
        return new response<T>(200,"操作成功",object);
    }

    public static <T> response<T> success(){
        return new response<T>(200,"操作成功");
    }

    public static <T> response<T> fail(){
        return new response<T>(404,"操作失败");
    }

    public static <T> response<T> fail(String message){
        return new response<T>(404,message);
    }
}
