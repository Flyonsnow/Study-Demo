package com.wenxuezheng.study.operation.log.report.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author    
 * 2022/8/5 14:45
 */
@Getter
@AllArgsConstructor
public enum PostTypeEnum {
    /**
     * 从方法参数中获取
     */
    PARAM,
    /**
     * 从返回值中获取
     */
    RETURN,
    /**
     * 参数中包含主键
     */
    PARAM_PRIMARY_KEY,

    /**
     * 参数为对象， 对象中包含主键
     */
    PARAM_OBJECT_PRIMARY_KEY;

}
