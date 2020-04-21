package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.domain.Account;
import org.example.service.IAccountService;
import org.example.utils.TransactionManager;

import java.util.List;

/**
 * 帳戶的業務層實現類
 * <p>
 * 事務的控制應該都是在業務層
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
        // 2.1. 根據名稱查詢轉出帳戶
        Account source = accountDao.findAccountByName(sourceName);
        // 2.2. 根據名稱查詢轉入帳戶
        Account target = accountDao.findAccountByName(targetName);
        // 2.3. 轉出帳戶減錢
        source.setMoney(source.getMoney() - money);
        // 2.4. 轉入帳戶加錢
        target.setMoney(target.getMoney() + money);
        // 2.5. 更新轉出帳戶
        accountDao.updateAccount(source);
//        int i = 1 / 0;
        // 2.6. 更新轉入帳戶
        accountDao.updateAccount(target);
    }
}
