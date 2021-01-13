package jdbc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/13 15:44
 * @return
 * 使用配置文件去取数据库相关信息
 */
public class JDBCUtilsProperties {
    public static Connection getConn() throws IOException, ClassNotFoundException, SQLException {
        Properties pro = new Properties();
        pro.load(new FileInputStream(new File("jdbc.properties")));
        Connection conn = null;
        String driver = pro.getProperty("driver");
        Class.forName(driver);
        String url = pro.getProperty("url");
        String username = pro.getProperty("username");
        String userPwd = pro.getProperty("password");
        conn = DriverManager.getConnection(url,username,userPwd);
        return conn;
    }

    public static void CloseAll(Connection conn, Statement st, ResultSet rs){
        try{
            if (rs!=null){
                rs.close();
            }
            if (st!=null){
                st.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
