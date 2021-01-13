package jdbc.core;

import jdbc.util.JDBCUtilsDruid2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/13 16:47
 * @return
 * 本类用于演示JDBC事物处理
 * 设置自动提交关闭，没有开启事物的代码，只要关闭自动提交就开启了事物。
 */
public class TestSeven {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = JDBCUtilsDruid2.getConn();
            String sql = "update major set majorname = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            ps.setString(1,"七年级");
            ps.setInt(2,7);
            ps.executeUpdate();
            int x = 10/0;
            ps.setString(1,"八年级");
            ps.setInt(2,8);
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

