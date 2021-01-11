package jdbc.core;

import java.sql.*;

public class StatementSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studb?user=root&password=000000&useUnicode=true&characterEncoding=utf-8");
            Statement st = conn.createStatement();
            String sql = "select stuname,id,gender from stuinfo";
            ResultSet rs = st.executeQuery(sql);
            System.out.println("stuname\tid\tgender");
            while (rs.next()){
                int id = rs.getInt("id");
                String stuname = rs.getString("stuname");
                String gender = rs.getString("gender");
                System.out.println(stuname+"\t"+id+"\t"+gender);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
