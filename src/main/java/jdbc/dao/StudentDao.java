package jdbc.dao;

import jdbc.entity.Student;
import jdbc.util.JDBCUtilsDruid2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/13 17:13
 * @return
 */
public class StudentDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public void addStudent(Student stu){
        try {
            conn = JDBCUtilsDruid2.getConn();
            String sql = "insert into stuinfo(id,stuname,borndate,email,majorid) values(8,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,stu.getStuName());
            ps.setString(2,stu.getStuBirthday());
            ps.setString(3,stu.getEmail());
            ps.setInt(4,stu.getClassesId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtilsDruid2.closeAll(conn,ps,null);
        }
    }

    public void updateStudent(Student stu){
        try {
            conn = JDBCUtilsDruid2.getConn();
            String sql = "update stuinfo set stuname=?,borndate=?,email=?,gender=?,seat=?,majorid=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,stu.getStuName());
            ps.setString(2,stu.getStuBirthday());
            ps.setString(3,stu.getEmail());
            ps.setString(4,stu.getStuGender());
            ps.setInt(5,stu.getSeat());
            ps.setInt(6,stu.getClassesId());
            ps.setInt(7,stu.getStuId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtilsDruid2.closeAll(conn,ps,null);
        }
    }


}
