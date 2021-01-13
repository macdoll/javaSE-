package jdbc.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/13 16:24
 * @return
 */
public class JDBCUtilsDruid2 {
    public static Connection getConn() throws Exception {
        Properties pro = new Properties();
        pro.load(new FileInputStream(new File("D:\\git_code\\github\\javase\\src\\main\\java\\jdbc\\util\\jdbc.properties")));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        return conn;
    }

    public static void closeAll(Connection conn, Statement st, ResultSet rs){
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
