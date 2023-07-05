package com.wenxuezheng.study.operation.log.report.dao;

import org.springframework.util.ClassUtils;

import java.io.Serializable;

/**
 * @author   
 * 2022/8/5 16:42
 */
public interface OperationLogDao<T> {
    T getById(Serializable id);
}
