package org.example.factory;

import org.example.service.IAccountService;
import org.example.service.impl.AccountServiceImpl;

/**
 * 模擬一個工廠類別 (該類可能是存在於 jar 包中的，我們無法透過修改源碼的方式來提供默認構造函數)
 */
public class StaticFactory {
    public static IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
