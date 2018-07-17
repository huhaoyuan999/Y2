package com.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 增强类（最终增强）
 */
@Aspect
public class AfterLogger {
    private static final Logger log = Logger.getLogger(AfterLogger.class);

    @Pointcut("execution(public void addInfo(..))")
    public void pointcut() {
    }

    /**
     * 最终增强
     */
    @After("pointcut()")
    public void after(JoinPoint jp) {
        log.info(jp.getSignature().getName() + "最终增强方法结束啦！");
    }

}
