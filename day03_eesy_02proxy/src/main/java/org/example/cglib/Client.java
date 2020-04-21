package org.example.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.example.proxy.IProducer;

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
         *  基於子類的動態代理:
         *      涉及的類: Enhancer
         *      提供者: 第三方 cglib 庫
         *  如何建立代理物件:
         *      使用 Enhancer 類中的 create 方法
         *  建立代理物件的要求:
         *      被代理類不能是最終類
         *  create 方法的參數:
         *      Class: 字節碼
         *          它是用於指定被代理物件的字節碼
         *      Callback: 用於提供增強的代碼
         *          它是讓我們寫如何代理，我們一般都是寫一個該接口的實現類，通常情況下都是匿名內部類，但不是必須的
         *          此接口的實現類都是誰用誰寫
         *          我們一般寫的都是該接口的子接口實現類， MethodInterceptor
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**   
             * 方法: 執行被代理類物件的任何方法都會經過該方法
             * @param proxy
             * @param method
             * @param args
             *      以上三個參數和基於接口的動態代理中 invoke 方法的參數是一樣的
             * @param methodProxy 當前執行方法的代理物件
             * @return 和被代理物件方法有相同的返回值
             */  
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
        cglibProducer.saleProduct(10000f);
    }
}
