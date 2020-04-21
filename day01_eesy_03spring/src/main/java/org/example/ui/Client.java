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
     * 方法: 獲取 Spring 的 Ioc 核心容器，並根據 id 獲取物件
     * ApplicationContext 的三個常用實現類
     *      ClassPathXmlApplicationContext: 它可以載入類路徑下的配置文件，要求配置文件必須在類路徑下。不再的話，載入不了。(更常用)
     *      FileSystemXmlApplicationContext: 它可以載入硬碟任意路徑下的配置文件 (必須有訪問權限)
     *
     *      AnnotationConfigApplicationContext: 它是用於讀取註解建立容器的。
     *
     * 核心容器的兩個接口引發出的問題
     *      ApplicationContext:     單例物件適用 (更常用)
     *          它在建立核心容器時，建立物件採取的策略是採用立即載入的方式。也就是說，只要一讀取完配置文件馬上就建立配置文件中配置的物件
     *      BeanFactory:            多例物件適用
     *          它在建立核心容器時，建立物件採取的策略是採用延遲載入的方式。也就是說，什麼時候根據 id 獲取物件，什麼時候才真正的建立物件
     */
    public static void main(String[] args) {
        // 1. 獲取核心容器物件
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\day01_eesy_03spring\\src\\main\\resources\\bean.xml");

        // 2. 根據 id 獲取 Bean 物件
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
        as.saveAccount();

        // --------- BeanFactory ------------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as = (IAccountService)factory.getBean("accountService");
//        System.out.println(as);
    }
}
