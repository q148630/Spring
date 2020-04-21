package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 和事務相關的配置類
 */
public class TransactionConfig {

    /**
     * 方法: 用於建立事務管理器物件
     * @param dataSource
     * @return org.springframework.transaction.PlatformTransactionManager
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
