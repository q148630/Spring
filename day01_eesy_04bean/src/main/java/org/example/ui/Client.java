package org.example.ui;

import org.example.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模擬一個表現層，用於調用業務層
 */
public class Client {

    /**
     * 方法: 獲取 Spring 的 Ioc 核心容器，並根據 id 獲取物件
     */
    public static void main(String[] args) {
        // 1. 獲取核心容器物件
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 2. 根據 id 獲取 Bean 物件
        IAccountService as1 = (IAccountService) ac.getBean("accountService");
//        IAccountService as2 = (IAccountService) ac.getBean("accountService");
        as1.saveAccount();
//        System.out.println(as1 == as2);

        // 手動關閉容器
        ac.close();
    }
}
