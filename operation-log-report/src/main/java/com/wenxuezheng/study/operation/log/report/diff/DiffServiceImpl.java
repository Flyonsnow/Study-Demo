package com.wenxuezheng.study.operation.log.report.diff;

import com.wenxuezheng.study.operation.log.report.dao.OperationLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author    
 * 2022/8/5 09:47
 */
@Component
public class DiffServiceImpl {

    @Autowired
    private Collection<OperationLogDao> operationLogDaoList;

    private static Map<Type, OperationLogDao> DAO_MAP;

    @PostConstruct
    public void init() {
        DAO_MAP = new HashMap<>(operationLogDaoList.size());
        for (OperationLogDao operationLogDao : operationLogDaoList) {
            // 获取范型类型
            Class<? extends OperationLogDao> aClass = operationLogDao.getClass();
            Type genericSuperclass = aClass.getGenericSuperclass();
            ResolvableType as = ResolvableType.forType(genericSuperclass).as(OperationLogDao.class);
            ResolvableType generic1 = as.getGeneric(0);
            Class<?> resolve = generic1.resolve();
            DAO_MAP.put(resolve, operationLogDao);
        }
    }

    public static void getDiff(Object originalObject, Object postObject) {
        Class<?> aClass = postObject.getClass();
        OperationLogDao operationLogDao = DAO_MAP.get(aClass);
        operationLogDao.getById("");
    }

    public static void getDiffWithPrimaryKey(Object originalObject, Serializable id) {

    }




}
