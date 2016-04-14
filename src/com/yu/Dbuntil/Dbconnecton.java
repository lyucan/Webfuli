package com.yu.Dbuntil;

import java.sql.*;

/**
 * Created by lenovo on 2016/4/13.
 */
public class Dbconnecton {
    public static Connection getconnection(){
        String username="root123";
        String password="123";
        String url="jdbc:mysql://localhost:3306/l_shop?useUnicode=true&characterEncoding=utf-8";
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(url,username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public static void close(Connection con){


        try {
            if (con != null)
                con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps){
        try {
            if (ps!= null)
                ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs){
        try {
            if (rs!= null)
                rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
