package org.example.jdbc;

import java.sql.*;

/**
 * 程式的耦合
 *      耦合: 程式間的依賴關係
 *          包括:
 *              類之間的依賴
 *              方法間的依賴
 *      解耦:
 *          降低程式間的依賴關係
 *      實際開發中:
 *          應該做到，編譯期不依賴，運行時才依賴
 *      解耦的思路:
 *          第一步，使用反射來建立物件，而避免使用 new 關鍵字
 *          第二步，透過讀取配置文件來獲取要建立的物件全限定類名
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1. 註冊驅動
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 獲取連接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy", "root", "admin8857810");
        // 3. 獲取操作資料庫的預處理類別
        PreparedStatement pstm = conn.prepareStatement("SELECT * FROM account");
        // 4. 執行 SQL，得到結果集
        ResultSet rs = pstm.executeQuery();
        // 5. 遍歷結果集
        while(rs.next()) {
            System.out.println(rs.getString("name"));
        }
        // 6. 釋放資源
        rs.close();
        pstm.close();
        conn.close();
    }
}
