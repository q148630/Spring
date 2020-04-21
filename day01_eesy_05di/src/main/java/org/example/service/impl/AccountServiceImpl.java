package org.example.service.impl;

import org.example.service.IAccountService;

import java.util.Date;

/**
 * 帳戶的業務層實現類
 */
public class AccountServiceImpl implements IAccountService {

    // 如果是經常變化的數據，並不適用於注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service 中的 saveAccount 方法執行了~ " + name + "," + age + "," + birthday);
    }

}
