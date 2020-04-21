package org.example.service.impl;

import org.example.dao.IAccountDao;
import org.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 帳戶的業務層實現類
 *
 * 曾經 XML 的配置:
 *  <bean id="accountService" class="org.example.service.impl.AccountServiceImpl"
 *        scope="" init-method="" destroy-method="">
 *      <property name="" value="" | ref=""></property>
 *  </bean>
 *
 * 用於建立物件的
 *      它們的作用就和在 XML 配置文件中編寫一個 <bean> 標籤實現的功能是一樣的
 *      @Component:
 *          作用: 用於把當前類物件存入 spring 容器中
 *          屬性:
 *              value: 用於指定 bean 的 id，當我們不寫時，它的默認值是當前類名，且首字母改小寫
 *      @Controller: 一般用在表現層
 *      @Service: 一般用在業務層
 *      @Repository: 一般用在持久層
 *      以上三個註解它們的作用和屬性與 @Component 是一模一樣，
 *      它們三個是 spring 框架為我們提供明確的三層使用的註解，使我們的三層物件更加清晰
 *
 * 用於注入數據的
 *      它們的作用就和在 XML 配置文件中的 bean 標籤中寫一個 <property> 標籤的作用是一樣的
 *      @Autowired:
 *          作用: 自動按照類型注入，只要容器中有唯一的一個 bean 物件類型和要注入的變數類型匹配，就可以注入成功
 *                如果 ioc 容器中沒有任何 bean 的類型和要注入的變數類型匹配，則報錯
 *                如果 ioc 容器中有多個類型匹配時，則會再和要注入的變數名進行匹配，如果變數名也沒有匹配成功，則報錯
 *          出現位置:
 *              可以是變數上，也可以是方法上
 *          細節: 在使用註解注入時，set 方法就不是必需的了
 *      @Qualifier:
 *          作用: 在按照類中注入的基礎之上再按照名稱注入，它在給類成員注入時不能單獨使用，但是在給方法參數注入時可以
 *          屬性:
 *              value: 用於指定注入 bean 的 id
 *      @Resource:
 *          作用: 直接按照 bean 的 id 注入，它可以獨立使用
 *          屬性:
 *              name: 用於指定 bean 的 id
 *      以上三個注入都只能注入其他 bean 類型的數據，而基本類型和 String 類型無法使用上述註解實現
 *      另外，集合類型的注入只能透過 XML 來實現
 *
 *      @Value:
 *          作用: 用於注入基本類型和 String 類型的數據
 *          屬性:
 *              value: 用於指定數據的值，它可以使用 spring 中 SpEL(也就是 spring 的 el 表達式)
 *                      SpEL 的寫法，${表達式}
 *
 * 用於改變作用範圍的
 *      它們的作用就和在 bean 標籤中使用 scope 屬性實現的功能是一樣的
 *      @Scope:
 *          作用: 用於指定 bean 的作用範圍
 *          屬性:
 *              value: 指定範圍的取值。常用取值: singleton prototype
 *
 * 和生命週期相關的
 *      它們的作用就和在 bean 標籤中使用 init-method 和 destroy-method 的作用是一樣的
 *      @PreDestroy:
 *          作用: 用於指定銷毀方法
 *      @PostConstruct:
 *          作用: 用於指定初始化方法
 */
@Service("accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    public void saveAccount() {

        accountDao.saveAccount();

    }

    @PostConstruct
    public void init() {
        System.out.println("初始化方法執行了~");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("銷毀方法執行了~");
    }
}
