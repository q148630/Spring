package org.example.ui;

import org.example.dao.IAccountDao;
import org.example.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模擬一個表現層，用於調用業務層
 */
public class Client {

    /**
     *
     */
    public static void main(String[] args) {
        // 1. 獲取核心容器物件
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 2. 根據 id 獲取 Bean 物件
        IAccountService as = (IAccountService)ac.getBean("accountService");
//        IAccountService as2 = (IAccountService)ac.getBean("accountService");
//        System.out.println(as);
//
//        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);
//        System.out.println(adao);
//        System.out.println(as == as2);
        as.saveAccount();
        ac.close();
    }
}
