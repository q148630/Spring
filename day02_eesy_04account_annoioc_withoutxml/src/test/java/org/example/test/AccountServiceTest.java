package org.example.test;

import config.SpringConfiguration;
import org.example.domain.Account;
import org.example.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用 Junit 單元測試: 測試我們的配置
 * Spring 整合 Junit 的配置
 *      1. 導入 spring 整合 junit 的 jar(座標)
 *      2. 使用 Junit 提供的一個註解把原有的 main 方法替換了，替換成 spring 提供的
 *              @Runwith
 *      3. 告知 spring 的運行器，spring 和 ioc 建立是基於 xml 還是註解的，並且說明位置
 *          @ContextConfiguration:
 *                  locations: 指定 xml 文件的位置，加上 classpath 關鍵字，表示在類路徑下
 *                  classes: 指定註解類所在的位置
 *
 * 當我們使用 spring 5.x 版本的時候，要求 junit 的 jar 必須是 4.12 及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
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
