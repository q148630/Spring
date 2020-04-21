package org.example.dao;

import org.example.domain.Account;

/**   
 * 帳戶的持久層接口
 */  
public interface IAccountDao {

    /**
     * 方法: 根據 Id 查詢帳戶
     * @param accountId
     * @return org.example.domain.Account  
     */  
    Account findAccountById(Integer accountId);

    /**
     * 方法: 根據名稱查詢帳戶
     * @param accountName
     * @return org.example.domain.Account
     */
    Account findAccountByName(String accountName);

    /**
     * 方法: 更新帳戶
     * @param account
     */
    void updateAccount(Account account);
}
