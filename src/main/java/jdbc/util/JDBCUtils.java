package jdbc.util;

import java.sql.*;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/13 16:03
 * @return
 * 用于提供数据库操作所需要的公共方法
 * 这个是最基础版本的
 */
public class JDBCUtils {
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studb?user=root&password=000000&useUnicode=true&characterEncoding=utf-8");
        return conn;
    }

    public static void closeAll(Connection conn, Statement st, ResultSet rs){
        try{
            if (rs != null){
                rs.close();
            }
            if (st != null){
                st.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
