package com.wenxuezheng.study.operation.log.report.annotation;

import com.wenxuezheng.study.operation.log.report.constant.PostTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author    
 * 2022/8/5 13:42
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OperationLogReport {
    /**
     * 获取修改后对象的方式, PARAM、RETURN、PRIMARY_KEY
     */
    PostTypeEnum postType() default PostTypeEnum.PARAM;

    /**
     * 使用PARAM获取修改后对象时， 参数的名称
     */
    String postParamName() default "";

}
