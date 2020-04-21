package org.example.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 測試 QuerryRunner 是否單例
 */
public class QueryRunnerTest {
    @Test
    public void testQueryRunner() {
        // 1. 取得容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 2. 取得 QueryRunner 物件
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner == runner1);
    }
}
