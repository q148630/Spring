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

    /**
     * 方法: 轉帳
     * @param sourceName 轉出帳戶名稱
     * @param targetName 轉入帳戶名稱
     * @param money 轉帳金額
     */
    void transfer(String sourceName, String targetName, Float money);

//    void test(); // 它只是連接點，但不是切入點，因為沒有被增強
}
