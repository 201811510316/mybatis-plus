package com.example.javatest3.utils;

public class response{

    public static ApiResponse SuccessInstance(){
        return new ApiResponse(200,null,null);
    }

    public static ApiResponse SuccessInstance(Object result){
        return new ApiResponse(200,null,result);
    }

    public static ApiResponse SuccessInstance(Object result,String message){
        return new ApiResponse(200,message,result);
    }

    public static ApiResponse FailedInstance(Object result){
        return new ApiResponse(404,null,result);
    }

    public static ApiResponse FailedInstance(String message){
        return new ApiResponse(404,message,null);
    }


}
