package org.example.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事務管理相關的工具類，它包含了: 開啟事務、提交事務、回滾事務和釋放連接
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* org.example.service.impl.*.*(..))")
    private void pt1(){}


    /**
     * 方法: 開啟事務
     */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法: 提交事務
     */
    public void comit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法: 回滾事務
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法: 釋放連接
     */
    public void release() {
        try {
            connectionUtils.getThreadConnection().close(); // 還回連接池
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            // 1. 取得參數
            Object[] args = pjp.getArgs();
            // 2. 開啟事務
            this.beginTransaction();
            // 3. 執行方法
            rtValue = pjp.proceed(args);
            // 4. 提交事務
            this.comit();

            return rtValue;
        } catch (Throwable e) {
            // 5. 回滾事務
            this.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6. 釋放連接
            this.release();
        }
    }

}
