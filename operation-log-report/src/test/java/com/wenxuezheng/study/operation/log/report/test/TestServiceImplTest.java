package com.wenxuezheng.study.operation.log.report.test;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author hu.bo
 * 2022/8/5 15:08
 */
@SpringBootTest
class TestServiceImplTest {

    @Autowired
    private TestServiceImpl testService;

    @Test
    void test1() {
        testService.test("testName");

    }

    @Test
    void test2() {
        Student student = new Student();
        List<String> names = Lists.newArrayList();
        names.add("a");
        names.add("b");
        student.setNames(names);
        student.setName("testname");
        testService.test2(student);

    }
}