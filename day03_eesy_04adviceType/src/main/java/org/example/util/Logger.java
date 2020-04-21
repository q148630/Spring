package org.example.util;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用於記錄日誌的工具類，它裡面提供了公共的代碼
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置通知Logger類中beforePrintLog方法開始記錄日誌了~");
    }

    /**
     * 後置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("後置通知Logger類中afterReturningPrintLog方法開始記錄日誌了~");
    }

    /**
     * 異常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("異常通知Logger類中afterThrowingPrintLog方法開始記錄日誌了~");
    }

    /**
     * 最終通知
     */
    public void afterPrintLog() {
        System.out.println("最終通知Logger類中afterPrintLog方法開始記錄日誌了~");
    }

    /**
     * 環繞通知
     * 問題:
     *      當我們配置了環繞通知之後，切入點方法沒有執行，而通知方法執行了
     * 分析:
     *      透過對比動態代理中的環繞通知代碼，發現動態代理的環繞通知有明確的切入點方法調用，而我們的代碼中沒有
     * 解決:
     *      Spring 框架為我們提供了一個接口: ProceedingJoinPoint。該接口有一個方法 proceed()，此方法就相當於明確調用切入點方法。
     *      該接口可以作為環繞通知的方法參數，在程式執行時，spring 框架會為我們提供該接口的實現類供我們使用。
     *
     * spring 中的環繞通知:
     *      它是 spring 框架為我們提供的一種可以在代碼中手動控制增強方法何時執行的方式
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs(); // 得到方法執行所需的參數

            System.out.println("Logger類中的aroundPrintLog方法開始記錄日誌了~ 前置");

            rtValue = pjp.proceed(); // 明確調用業務層方法 (切入點方法)

            System.out.println("Logger類中的aroundPrintLog方法開始記錄日誌了~ 後置");

            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("Logger類中的aroundPrintLog方法開始記錄日誌了~ 異常");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("Logger類中的aroundPrintLog方法開始記錄日誌了~ 最終");
        }
    }
}
