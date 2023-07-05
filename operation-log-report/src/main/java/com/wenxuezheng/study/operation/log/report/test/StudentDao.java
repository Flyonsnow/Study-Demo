package com.wenxuezheng.study.operation.log.report.test;

import com.wenxuezheng.study.operation.log.report.dao.OperationLogDao;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * @author hu.bo
 * 2022/8/5 16:51
 */
@Component
public class StudentDao implements OperationLogDao<Student> {

    @Override
    public Student getById(Serializable id) {
        return null;
    }
}
