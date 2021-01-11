package jdbc.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Connection类型是属于java.sql包下的
 */
public class JDBCUtilsDruid {
    public static Connection getConn() throws SQLException {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/studb");
        ds.setUsername("root");
        ds.setPassword("000000");
        ds.setDriverClassName("com.mysql.jdbc.Driver");

        ds.setInitialSize(10);
        ds.setMaxActive(20);
        ds.setMinIdle(1);

        DruidPooledConnection conn = ds.getConnection();
        System.out.println(conn);
        return conn;
    }

    public static void closeAll(Connection con, Statement st, ResultSet rs) throws SQLException {
        if (rs!=null){
            rs.close();
        }if (st!=null){
            st.close();
        }if (con!=null){
            con.close();
        }
    }
}
