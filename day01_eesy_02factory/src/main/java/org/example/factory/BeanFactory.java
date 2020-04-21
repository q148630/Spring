package org.example.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一個建立 Bean 物件的工廠
 * Bean: 在計算機英語中，有可重用組件的含義
 * JavaBean: 用 java 語言編寫的可重用組件
 *      javabean > 實體類
 * 它就是建立我們的 service 和 dao 對象的
 * 第一個，需要一個配置文件來配置我們的 service 和 dao
 *      配置的內容: 唯一標識 = 全限定類名 (key = value)
 * 第二個，透過讀取配置文件中配置的內容，反射建立物件
 *
 * 我的配置文件可以是 xml 也可以是 properties
 */
public class BeanFactory {
    // 定義一個 Properties 物件
    private static Properties props;

    // 定義一個 Map，用於存放我們要建立的物件，我們把它稱之為容器
    private static Map<String, Object> beans;

    // 使用靜態代碼為 Properties 物件賦值
    static {

        try {
            // 實例化物件
            props = new Properties();
            // 獲取 properties 文件的 InputStream
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            // 實例化容器
            beans = new HashMap<String, Object>();
            // 取出配置文件中所有的 key
            Enumeration<Object> keys = props.keys();
            // 遍歷枚舉
            while (keys.hasMoreElements()) {
                // 取出每個 key
                String key = keys.nextElement().toString();
                try {
                    // 根據 key 獲取 value
                    String beanPath = props.getProperty(key);
                    // 反射建立物件
                    Object value = Class.forName(beanPath).newInstance();
                    // 把 key 和 value 存入容器中
                    beans.put(key, value);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化 properties 失敗");
        }
    }

    /**
     * 方法: 根據 Bean 的名稱獲取 bean 物件 (單例的)
     * @param beanName
     * @return java.lang.Object
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

    /**
     * 方法: 根據 Bean 的名稱獲取 bean 物件 (多例的)
     * @param beanName
     * @return java.lang.Object
     */
//    public static Object getBean(String beanName) {
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance(); // 每次都會調用默認構造函數建立物件
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
