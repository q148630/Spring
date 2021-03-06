package org.example.service;

import org.example.domain.Account;

import java.util.List;

/**
 * 帳戶的業務層接口
 */  
public interface IAccountService {

    /**
     * 方法: 查詢所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 方法: 查詢一個
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 方法: 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 方法: 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 方法: 刪除
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
