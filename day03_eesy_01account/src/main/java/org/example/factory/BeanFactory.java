package org.example.factory;

import org.example.domain.Account;
import org.example.service.IAccountService;
import org.example.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用於建立 Service 的代理物件的工廠
 */
public class BeanFactory {

    private IAccountService accountService;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }


    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 方法: 取得 Service 代理物件
     *
     * @return
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**   
                     * 方法: 添加事務的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return java.lang.Object  
                     */  
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if("test".equals(method.getName())) {
                            return method.invoke(accountService, args);
                        }
                        Object rtValue = null;
                        try {
                            // 1. 開啟事務
                            txManager.beginTransaction();
                            // 2. 執行操作
                            rtValue = method.invoke(accountService, args);
                            // 3. 提交事務
                            txManager.comit();
                            // 4. 返回結果
                            return rtValue;
                        } catch (Exception e) {
                            // 5. 回滾操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            // 6. 釋放連接
                            txManager.release();
                        }
                    }
                });
    }


}
