package org.example.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 連接的工具類，它用於從數據源中取得一個連接，並且實現和線程的綁定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 方法: 取得當前線程上的連接
     *
     * @return
     */
    public Connection getThreadConnection() {
        // 1. 先從 ThreadLocal 上取得
        Connection conn = tl.get();
        try {
            // 2. 判斷當前線程上是否有連接
            if (conn == null) {
                // 3. 從數據源中取得一個連接，並且存入 ThreadLocal 中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            // 4. 返回當前線程上的連接
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**   
     * 方法: 把連接和線程解綁
     */  
    public void removeConnection() {
        tl.remove();
    }

}
