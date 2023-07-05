package com.wenxuezheng.study.operation.log.report.test;

import com.wenxuezheng.study.operation.log.report.annotation.OperationLogPrimaryKey;
import lombok.Data;

import java.util.List;


/**
 * @author hu.bo
 * 2022/8/5 16:50
 */
@Data
public class Student {
    @OperationLogPrimaryKey
    private Long id;
    private String name;
    private List<String> names;
}
