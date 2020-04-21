package org.example.util;

/**
 * 用於記錄日誌的工具類，它裡面提供了公共的代碼
 */
public class Logger {

    /**
     * 方法: 用於印出日誌，計畫讓其在切入點方法執行之前執行 (切入點方法就是業務層方法)
     */
    public void printLog() {
        System.out.println("Logger類中printLog方法開始記錄日誌了~");
    }
}
