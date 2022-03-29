package com.wenxuezheng.study.minio.minio.exception;

import com.wenxuezheng.study.minio.minio.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author hu.bo@cestc.cn
 * @date 2022/3/29 9:11 PM
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        return Result.error(e.getMessage());
    }
}
