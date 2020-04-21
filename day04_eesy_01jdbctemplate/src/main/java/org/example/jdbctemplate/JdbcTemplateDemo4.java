package org.example.jdbctemplate;

import org.example.dao.IAccountDao;
import org.example.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate 的最基本用法
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args) {

        // 1. 取得容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 取得物件
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        account.setMoney(30000f);
        accountDao.updateAccount(account);
    }
}
