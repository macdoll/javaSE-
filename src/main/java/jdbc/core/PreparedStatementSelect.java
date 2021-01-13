package jdbc.core;

import jdbc.util.JDBCUtilsDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * PreparedStatement基础查询
 * PreparedStatement有占位符
 * 站位符可以使得拼接sql不需要断开，使用站位符站位，然后在填充占位符参数。
 * PreparedStatement在执行sql语句之前有一个预编译的动作。这个预编译可以提高sql执行的效率。
 * 以后一律使用PreparedStatement代替Statement
 * new Scanner(System.in)的对象input可以用来多次输入，input.next()
 * 使用德鲁伊连接池获取连接的方式
 * ps在创建对象的时候就需要给出sql语句。
 * 填充站位符的值，问号从sql语句左侧开始查，第一个问号的索引是1，以此类推。
 * ps在执行sql语句的时候是没有参数的。
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
