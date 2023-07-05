package com.wenxuezheng.study.minio.minio.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * @author    
 * @date 2022/3/29 5:43 PM
 */
@Slf4j
@Data
public class Result {
    private int code;

    private String message;

    private Object data;

    private Result() {
    }

    private Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return success("操作成功");
    }


    public static Result success(String message,Object data) {
        return new Result(200,message,data);
    }
    public static Result success(Object data) {
        return new Result(200,"操作成功",data);
    }

    public static Result error() {
        return new Result(500,"操作失败",null);
    }
    public static Result error(String message) {
        return new Result(500,message,null);
    }
}
