package org.example.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate 的最基本用法
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        // 準備數據源，spring 的內置數據源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("admin8857810");

        // 1. 建立 JdbcTemplate 物件
        JdbcTemplate jt = new JdbcTemplate();
        // 給 jt 設置數據源
        jt.setDataSource(ds);
      // 2. 執行操作
        jt.execute("INSERT INTO account(name , money) VALUE ('ccc', 1000)");
    }
}
