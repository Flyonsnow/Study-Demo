package com.wenxuezheng.study.operation.log.report.aop;

import com.wenxuezheng.study.operation.log.report.annotation.OperationLogReport;
import com.wenxuezheng.study.operation.log.report.constant.PostTypeEnum;
import com.wenxuezheng.study.operation.log.report.diff.DiffServiceImpl;
import com.wenxuezheng.study.operation.log.report.util.AopUtils;
import com.wenxuezheng.study.operation.log.report.util.ReflectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author    
 * 2022/8/5 14:05
 */

@Aspect
@Component
public class OperationLogAop {

    @Pointcut("execution(* com.wenxuezheng.study.operation.log.report..*(..)) & @annotation(OperationLogReport)")
    public void point() {
    }


    @Around("point()")
    public Object operation(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature msg = (MethodSignature) signature;
        Object target = joinPoint.getTarget();
        //获取注解标注的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        //通过方法获取注解
        OperationLogReport annotation = method.getAnnotation(OperationLogReport.class);
        Assert.notNull(annotation, "annotation must not be null");

        Object originalObject = null;

        Object returnObject = null;
        try {
            returnObject = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        // 获取修改后的对象, 如果通过参数和返回值，则直接获取， 若通过id，则获取id
        PostTypeEnum postType = annotation.postType();
        String postParamName = annotation.postParamName();
        Object postObject = null;
        Serializable id = null;
        switch (postType) {
            case PARAM -> {
                Assert.isTrue(postParamName != null && !"".equals(postParamName),
                        "postParamName must not be empty");
                postObject = AopUtils.getBeanByAnnotationParamName(postParamName, joinPoint);
                Assert.notNull(postObject, "获取参数失败");
                DiffServiceImpl.getDiff(originalObject, postObject);
            }
            case RETURN -> {
                postObject = returnObject;
                Assert.notNull(postObject, "获取参数失败");
                DiffServiceImpl.getDiff(originalObject, postObject);
            }
            case PARAM_PRIMARY_KEY -> {
                Object primaryKey = AopUtils.getBeanByAnnotationParamName(postParamName, joinPoint);
                if (primaryKey instanceof Serializable ser) {
                    id = ser;
                } else {
                    throw new UnsupportedOperationException("不支持的主键类型");
                }
                DiffServiceImpl.getDiffWithPrimaryKey(originalObject, id);
            }
            case PARAM_OBJECT_PRIMARY_KEY -> {
                Object paramObj = AopUtils.getBeanByAnnotationParamName(postParamName, joinPoint);
                Assert.notNull(paramObj, "获取参数失败");
                Object primaryKey = null;
                try {
                    primaryKey = ReflectUtils.getPrimaryKeyValue(paramObj);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (primaryKey instanceof Serializable ser) {
                    id = ser;
                } else {
                    throw new UnsupportedOperationException("不支持的主键类型");
                }
                DiffServiceImpl.getDiffWithPrimaryKey(originalObject, id);
            }
            default -> throw new UnsupportedOperationException("不支持的主键类型");
        }
        return returnObject;

        //for (Object arg : args) {
        //    Field[] declaredFields = arg.getClass().getDeclaredFields();
        //    for (Field declaredField : declaredFields) {
        //        Class<?> type = declaredField.getType();
        //        declaredField.setAccessible(true);
        //        Object o = declaredField.get(arg);
        //        if(o instanceof Collection){
        //            System.out.println("Collection");
        //        }
        //
        //
        //        System.out.println("type:" + type);
        //
        //        System.out.println(declaredField);
        //    }
        //}
    }

    private Object getOriginalObjectById(Serializable id) {


        return null;
    }

}
