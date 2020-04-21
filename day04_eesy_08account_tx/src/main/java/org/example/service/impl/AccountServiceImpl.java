package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.domain.Account;
import org.example.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * 帳戶的業務層實現類
 *
 * 事務的控制應該都是在業務層
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(final Integer accountId) {
        return transactionTemplate.execute(new TransactionCallback<Account>() {
            public Account doInTransaction(TransactionStatus transactionStatus) {
                return accountDao.findAccountById(accountId);
            }
        });
    }

    public void transfer(final String sourceName, final String targetName, final Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
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
//                int i = 1 / 0;
                // 2.6. 更新轉入帳戶
                accountDao.updateAccount(target);
                return null;
            }
        });

    }
}
