package org.example.service;

import org.example.domain.Account;

/**
 * 帳戶的業務層接口
 */
public interface IAccountService {

    /**
     * 方法: 根據 Id 查詢帳戶信息
     * @param accountId
     * @return org.example.domain.Account
     */
    Account findAccountById(Integer accountId);

    /**
     * 方法: 轉帳
     * @param sourceName 轉出帳戶名稱
     * @param targetName 轉入帳戶名稱
     * @param money 轉帳金額
     */
    void transfer(String sourceName, String targetName, Float money);

}
