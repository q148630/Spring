package org.example.test;

import org.example.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 測試 AOP 的配置
 */
public class AOPTest {
    public static void main(String[] args) {
        // 1. 取得容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 取得 bean 物件
        IAccountService as = (IAccountService) ac.getBean("accountService");
        // 3. 執行方法
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }
}
