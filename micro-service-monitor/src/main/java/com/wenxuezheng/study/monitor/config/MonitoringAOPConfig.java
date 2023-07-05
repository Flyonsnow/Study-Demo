package com.wenxuezheng.study.monitor.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.concurrent.TimeUnit;

import static java.util.jar.Pack200.Packer.ERROR;


/**
 * @author    
 * @date 2022/4/7 10:12 AM
 */
@Configuration
@EnableAspectJAutoProxy
@Aspect
public class MonitoringAOPConfig {
    @Autowired
    MeterRegistry registry;

    private static final String TAG_VALUE_SERVICE_TYPE = "SERVICE";
    private static final String METER_COMPONENT_TIMER = "component_invocation_timer";
    private static final String TAG_COMPONENT_CLASS = "componentClass";
    private static final String TAG_METHOD_NAME = "methodName";
    private static final String TAG_OUTCOME = "TAG_OUTCOME";
    private static final String SUCCESS = "SUCCESS";
    private static final String TAG_TYPE = "TAG_TYPE";
    private static final String METER_COMPONENT_COUNTER = "component_invocation_counter";
    private static final String METER_COMPONENT_EXCEPTION_COUNTER = "component_invocation_exception_counter";
    private static final String TAG_EXCEPTION_CLASS = "exceptionClass";

    @Pointcut("@target(com.wenxuezheng.study.monitor.annotation.MonitoredService) && within(com.wenxuezheng.study.monitor..*)")
    public void servicePointcut() {
    }

    @Around("servicePointcut()")
    public Object serviceResponseTimeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        return monitorResponseTime(pjp, TAG_VALUE_SERVICE_TYPE);
    }

    @AfterThrowing(pointcut = "servicePointcut()", throwing = "ex")
    public void serviceExceptionMonitoringAdvice(JoinPoint joinPoint, Exception ex)
    {
        monitorException(joinPoint, ex, TAG_VALUE_SERVICE_TYPE);
    }

    private Object monitorResponseTime(ProceedingJoinPoint pjp, String type) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        pjp.getStaticPart();
        long end = System.currentTimeMillis();
        String serviceClass = getClassName(pjp.getTarget().getClass().getName());
        String methodName = pjp.getSignature().getName();

        Timer timer = registry.timer(METER_COMPONENT_TIMER,
                TAG_COMPONENT_CLASS, serviceClass, TAG_METHOD_NAME, methodName, TAG_OUTCOME, SUCCESS, TAG_TYPE, type);
        timer.record((end - start), TimeUnit.MILLISECONDS);

        Counter successCounter = registry.counter(METER_COMPONENT_COUNTER,
                TAG_COMPONENT_CLASS, serviceClass, TAG_METHOD_NAME, methodName, TAG_OUTCOME, SUCCESS, TAG_TYPE, type);
        successCounter.increment();
        return obj;
    }

    private void monitorException(JoinPoint joinPoint, Exception ex, String type)
    {
        String serviceClass = getClassName(joinPoint.getThis().getClass().getName());
        String methodName = joinPoint.getSignature().getName();
        Counter failureCounter = registry.counter(METER_COMPONENT_EXCEPTION_COUNTER, TAG_EXCEPTION_CLASS,
                ex.getClass().getName(), TAG_COMPONENT_CLASS, serviceClass, TAG_METHOD_NAME, methodName, TAG_OUTCOME,
                ERROR,
                TAG_TYPE, type);
        failureCounter.increment();
    }


    private String getClassName(String name) {
        return name;
    }
}
