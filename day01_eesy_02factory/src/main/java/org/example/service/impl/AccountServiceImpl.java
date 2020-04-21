package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.factory.BeanFactory;
import org.example.service.IAccountService;

/**
 * 帳戶的業務層實現類
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

//    private int i = 1; // 因為是單例的，所以不建議使用類全域變數

    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i++);
    }
}
