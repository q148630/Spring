package org.example.test;

import org.example.domain.Account;
import org.example.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用 Junit 單元測試: 測試我們的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll() {

        // 3. 執行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account: accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {

        // 3. 執行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);

        // 3. 執行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {

        // 3. 執行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {

        // 3. 執行方法
        as.deleteAccount(4);
    }
}
