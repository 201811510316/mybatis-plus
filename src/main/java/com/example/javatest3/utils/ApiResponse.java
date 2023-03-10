package com.example.javatest3.utils;

public class ApiResponse extends BaseApiResponse{

    private Object result;

    public ApiResponse() {
        super();
    }

    public ApiResponse(Integer code,String message,Object result){
        super();
        this.code=code;
        this.message=message;
        this.result=result;
    }

    public ApiResponse(Integer code,Object result){
        super();
        this.code=code;
        this.result=result;
    }

    public ApiResponse(Integer code,String message,Object result,String errCode){
        super();
        this.code=code;
        this.errCode=errCode;
        this.message=message;
        this.result=result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean success(){
        return this.getCode()==200;
    }
}
