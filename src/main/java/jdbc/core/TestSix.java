package jdbc.core;

import jdbc.util.JDBCUtilsDruid2;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/13 16:37
 * @return
 * 批处理
 * 如果需要向数据库中插入多条数据库，按条写入效率低
 * 一次性写入若干条数据。就可以看做是一种批处理。
 * addBatch添加本次操作进批处理
 * executeBatch处理一批数据
 * clearBatch处理完的数据清空缓存
 */
public class TestSix {
    public static void main(String[] args) throws Exception {
        Connection conn = JDBCUtilsDruid2.getConn();
        String sql = "insert into major values(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i=20;i<=500;i++){
            ps.setInt(1,i);
            ps.setString(2,i+"年级");
            ps.addBatch();
            if (i%100==0){
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        ps.close();
        conn.close();
    }
}
