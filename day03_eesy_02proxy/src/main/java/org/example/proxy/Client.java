package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模擬一個消費者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 動態代理:
         *  特點: 字節碼隨用隨建立，隨用隨載入
         *  作用: 不修改源碼的基礎上對方法增強
         *  分類:
         *      基於接口的動態代理
         *      基於子類的動態代理
         *  基於接口的動態代理:
         *      涉及的類: Proxy
         *      提供者: JDK 官方
         *  如何建立代理物件:
         *      使用 Proxy 類中的 newProxyInstance 方法
         *  建立代理物件的要求:
         *      被代理類最少實現一個接口，如果沒有則不能使用
         *  newProxyInstance 方法的參數:
         *      ClassLoader: 類載入器
         *          它是用於載入代理物件字節碼的，和被代理物件使用相同的類載入器，固定寫法
         *      Class[]: 字節碼陣列
         *          它是用於讓代理物件和被代理物件有相同的方法，固定寫法
         *      InvocationHandler: 用於提供增強的代碼
         *          它是讓我們寫如何代理，我們一般都是寫一個該接口的實現類，通常情況下都是匿名內部類，但不是必須的
         *          此接口的實現類都是誰用誰寫
         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 方法: 執行被代理物件的任何接口方法都會經過該方法
                     * 方法參數的含義
                     * @param proxy 代理物件的引用
                     * @param method 當前執行的方法
                     * @param args 當前執行方法所需的參數
                     * @return 和被代理物件方法有相同的返回值
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 提供增強的代碼
                        Object returnValue = null;
                        // 1. 取得方法執行的參數
                        Float money = (Float)args[0];
                        // 2. 判斷當前方法是不是銷售
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduct(10000f);
    }
}
