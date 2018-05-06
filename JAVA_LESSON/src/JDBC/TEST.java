package JDBC;
/**
 * 测试sql语句与注入
 */

import NETWork.CloseUtil;

import java.sql.*;

public class TEST {
    public static void main(String[] args) throws ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            long start = System.currentTimeMillis();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST",
                    "root","rihoko");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println(end-start);
//            Statement stmt = conn.createStatement();//有注入风险，不使用
//            String name = "chika";
//
//            String sql1 = "select * from t_user";
//            String sql2 = "INSERT INTO t_user (username,password,regTime) value('"+name+"',123456,NOW());";
//            //测试sql注入
//            String id = "4 or 1 = 1";
//            String sql3  ="delete from t_user where id = "+id;
//            stmt.execute(sql3);
//            String name = "ruby";
//            String sql1 = "INSERT INTO t_user (username,password,regTime) value(?,?,?);";//占位符
//            PreparedStatement pstmt = conn.prepareStatement(sql1);
////            pstmt.setString(1,name);//JDBC从1开始计算,herbinate从0开始计算
////            pstmt.setString(2,"123456");
////            pstmt.setDate(3,new Date(System.currentTimeMillis()));
//            pstmt.setObject(1,name);
//            pstmt.setObject(2,"123456");
//            pstmt.setDate(3,new java.sql.Date(System.currentTimeMillis()));
//            System.out.println("插入一条记录");
//            pstmt.execute();
//            int count = pstmt.executeUpdate();
//            System.out.println(count);
            String sql1 = "select id,username,password from t_user where id > ?";
             pstmt = conn.prepareStatement(sql1);
            pstmt.setObject(1,2);
             rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+
                        rs.getString(3));
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt !=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
