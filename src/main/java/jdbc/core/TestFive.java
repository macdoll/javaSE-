package jdbc.core;

import jdbc.util.JDBCUtilsDruid;
import jdbc.util.JDBCUtilsProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/13 15:33
 * @return
 * 本类用于演示PreparedStatement执行更新操作
 *
 */
public class TestFive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("update id");
        Integer id = input.nextInt();
        System.out.println("update name");
        String name = input.next();
        System.out.println("update birthday");
        String birthday = input.next();
        System.out.println("update gender");
        String gender = input.next();

        try {
            Connection conn = JDBCUtilsProperties.getConn();
            String sql = "update stuinfo set stuname=?,borndate=?,gender=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,birthday);
            ps.setString(3,gender);
            ps.setInt(4,id);

            int index = ps.executeUpdate();
            if (index==1){
                System.out.println("success");
            }else{
                System.out.println("failed");
            }
            JDBCUtilsProperties.CloseAll(conn,ps,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
