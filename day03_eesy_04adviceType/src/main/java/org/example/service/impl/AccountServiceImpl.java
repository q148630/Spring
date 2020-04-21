package org.example.service.impl;

import org.example.service.IAccountService;

/**
 * 帳戶的業務層實現類
 */
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("執行了保存");
//        int i = 1 / 0;
    }

    public void updateAccount(int i) {
        System.out.println("執行了更新" + i);
    }

    public int deleteAccount() {
        System.out.println("執行了刪除");
        return 0;
    }
}
