package org.example.service.impl;

import org.example.service.IAccountService;

import java.util.Date;

/**
 * 帳戶的業務層實現類
 */
public class AccountServiceImpl2 implements IAccountService {

    // 如果是經常變化的數據，並不適用於注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service 中的 saveAccount 方法執行了~ " + name + "," + age + "," + birthday);
    }

}
