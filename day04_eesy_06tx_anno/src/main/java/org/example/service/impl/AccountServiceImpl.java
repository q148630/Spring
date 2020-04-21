package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.domain.Account;
import org.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 帳戶的業務層實現類
 * <p>
 * 事務的控制應該都是在業務層
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) // 只讀型事務的配置
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    // 需要的是讀寫型事務配置
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
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
