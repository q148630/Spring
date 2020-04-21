package org.example.ui;

import org.example.factory.BeanFactory;
import org.example.service.IAccountService;
import org.example.service.impl.AccountServiceImpl;

/**
 * 模擬一個表現層，用於調用業務層
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
