package com.wenxuezheng.study.operation.log.report.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;

/**
 * @author hu.bo
 * 2022/8/5 14:54
 */

public class AopUtils {

    public static Object getBeanByAnnotationParamName(String paramName, ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < parameterNames.length; i++) {
            if (parameterNames[i].equalsIgnoreCase(paramName)) {
                return args[i];
            }
        }
        return null;
    }
}