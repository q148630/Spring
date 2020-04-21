package org.example.jdbctemplate;

import org.example.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate 的 CRUD 操作
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {

        // 1. 取得容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 取得物件
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // 3. 執行操作
        // 保存
//        jt.update("INSERT INTO account(name, money) VALUE (?, ?)", "eee", 3333f);
        // 更新
//        jt.update("UPDATE account SET name=?, money=? WHERE id=?", "test", 4567, 10);
        // 刪除
//        jt.update("DELETE FROM account WHERE id=?", 10);

        // 查詢所有
//        List<Account> accounts = jt.query("SELECT * FROM account WHERE money > ?", new AccountRowMapper(), 1000f);
//        List<Account> accounts = jt.query("SELECT * FROM account WHERE money > ?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
//        for (Account account: accounts) {
//            System.out.println(account);
//        }

        // 查詢一個
//        List<Account> accounts = jt.query("SELECT * FROM account WHERE id = ?", new BeanPropertyRowMapper<Account>(Account.class), 1);
//        System.out.println(accounts.isEmpty()? "沒有內容":accounts.get(0));

        // 查詢返回一行一列 (使用聚合函數，但不加 GROUP BY 子句)
        Long count = jt.queryForObject("SELECT COUNT(*) FROM account WHERE money > ?", Long.class, 1000f);
        System.out.println(count);
    }
}

/**
 * 定義 Account 的封裝策略
 */
class AccountRowMapper implements RowMapper<Account> {

    /**
     * 方法: 把結果集的資料封裝到 Account 中，然後由 spring 把每個 Account 加到集合中
     * @param resultSet
     * @param i
     * @return org.example.domain.Account
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}