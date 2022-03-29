package com.wenxuezheng.study.minio.minio.controller;

import com.wenxuezheng.study.minio.minio.bean.MinioBean;
import com.wenxuezheng.study.minio.minio.pojo.Result;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author hu.bo@cestc.cn
 * @date 2022/3/29 4:55 PM
 */
@Slf4j
@RestController
public class FileController {
    @Autowired
    private MinioBean minioComp;

    @PostMapping(value = "/upload")
    public Result upload(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
        minioComp.upload(file, fileName);
        String url = minioComp.getUrl(fileName, 7, TimeUnit.DAYS);
        return Result.success(url);
    }

    @GetMapping("/policy")
    public Result policy(@RequestParam("fileName") String fileName) {
        Map policy = minioComp.getPolicy(fileName, ZonedDateTime.now().plusMinutes(10));
        return Result.success(policy);
    }

    @GetMapping("/uploadUrl")
    public Result uploadUrl(@RequestParam("fileName") String fileName) {
        String url = minioComp.getPolicyUrl(fileName, Method.PUT, 2, TimeUnit.MINUTES);
        return Result.success(url);
    }

    @GetMapping("/url")
    public Result getUrl(@RequestParam("fileName") String fileName) {
        String url = minioComp.getUrl(fileName, 7, TimeUnit.DAYS);
        return Result.success(url);
    }
}
