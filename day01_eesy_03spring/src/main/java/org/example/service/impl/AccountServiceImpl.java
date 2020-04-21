package org.example.service.impl;

import org.example.service.IAccountService;

/**
 * 帳戶的業務層實現類
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public AccountServiceImpl() {
        System.out.println("AccountService 物件建立完成");
    }

    public void saveAccount() {

//        accountDao.saveAccount();

    }
}
