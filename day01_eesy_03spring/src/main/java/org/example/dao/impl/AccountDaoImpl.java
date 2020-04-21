package org.example.dao.impl;

import org.example.dao.IAccountDao;

/**
 * 帳戶的持久層實現類
 */
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了帳戶");
    }
}
