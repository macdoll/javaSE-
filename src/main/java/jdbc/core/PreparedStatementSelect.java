package jdbc.core;

import jdbc.util.JDBCUtilsDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * PreparedStatement基础查询
 * PreparedStatement有占位符
 *
 * new Scanner(System.in)的对象input可以用来多次输入，input.next()
 */
public class PreparedStatementSelect {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学员名字");
        String name = input.next();
        System.out.println("请输入生日");
        String birthday = input.next();
        System.out.println("请输入性别");
        String gender = input.next();

        try {
            Connection conn = JDBCUtilsDruid.getConn();
            String sql = "insert into stuinfo values(7,?,?,null,?,1008,3)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, birthday);
            ps.setString(3, gender);
            int index = ps.executeUpdate();
            if (index==1){
                System.out.println("success");
            }else {
                System.out.println("failed");
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
