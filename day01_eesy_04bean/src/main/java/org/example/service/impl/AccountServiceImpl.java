package org.example.service.impl;

import org.example.service.IAccountService;

/**
 * 帳戶的業務層實現類
 */
public class AccountServiceImpl implements IAccountService {


    public AccountServiceImpl() {
        System.out.println("AccountService 物件建立完成");
    }

    public void saveAccount() {
        System.out.println("service 中的 saveAccount 方法執行了~");
    }

    public void init() {
        System.out.println("物件初始化了~");
    }

    public void destroy() {
        System.out.println("物件銷毀了~");
    }


}
