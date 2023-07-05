package com.wenxuezheng.study.operation.log.report.util;

import com.wenxuezheng.study.operation.log.report.annotation.OperationLogPrimaryKey;

import java.lang.reflect.Field;

/**
 * @author   
 * 2022/8/5 17:57
 */
public class ReflectUtils {


    public static Object getPrimaryKeyValue(Object paramObj) throws IllegalAccessException {
        Field[] declaredFields = paramObj.getClass().getDeclaredFields();
        Object val = null;
        for (Field declaredField : declaredFields) {
            OperationLogPrimaryKey annotation = declaredField.getAnnotation(OperationLogPrimaryKey.class);
            if (annotation != null) {
                declaredField.setAccessible(true);
                val = declaredField.get(paramObj);
                break;
            }
        }
        return val;
    }
}
