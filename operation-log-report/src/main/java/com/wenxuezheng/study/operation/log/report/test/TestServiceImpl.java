package com.wenxuezheng.study.operation.log.report.test;

import com.wenxuezheng.study.operation.log.report.annotation.OperationLogReport;
import com.wenxuezheng.study.operation.log.report.constant.PostTypeEnum;
import org.springframework.stereotype.Service;


/**
 * @author hu.bo
 * 2022/8/5 14:58
 */
@Service
public class TestServiceImpl {

    @OperationLogReport(
            postType = PostTypeEnum.PARAM,
            postParamName = "name"

    )
    public void test(String name) {

    }

    @OperationLogReport(
            postType = PostTypeEnum.PARAM,
            postParamName = "student"

    )
    public void test2(Student student) {

    }
}
