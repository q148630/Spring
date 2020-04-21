package org.example.service;

/**
 * 帳戶的業務層接口
 */
public interface IAccountService {

    /**
     * 方法: 模擬保存帳戶
     */
    void saveAccount();

    /**
     * 方法: 模擬更新帳戶
     * @param i
     */
    void updateAccount(int i);

    /**
     * 方法: 模擬刪除帳戶
     * @return int
     */
    int deleteAccount();
}
