package org.example.test;

import org.example.domain.Account;
import org.example.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用 Junit 單元測試: 測試我們的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() {
        // 1. 取得容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到業務層物件
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        // 3. 執行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account: accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        // 1. 取得容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到業務層物件
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        // 3. 執行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        // 1. 取得容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到業務層物件
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        // 3. 執行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        // 1. 取得容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到業務層物件
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        // 3. 執行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        // 1. 取得容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 得到業務層物件
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        // 3. 執行方法
        as.deleteAccount(4);
    }
}
