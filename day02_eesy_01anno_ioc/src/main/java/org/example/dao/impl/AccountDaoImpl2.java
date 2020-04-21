package org.example.dao.impl;

import org.example.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 帳戶的持久層實現類
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了帳戶22222222222");
    }
}
