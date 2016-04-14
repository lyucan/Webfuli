package com.yu.Dao;


import com.yu.Dbuntil.Dbconnecton;
import com.yu.model.User;
import com.yu.model.shopException;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/4/7.
 */
public class Userdao implements Iuserdao {

    @Override
    public void add(User user) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
       try {
           con= Dbconnecton.getconnection();
           String sql="select count(*) from L_uesr where username=?";
           ps=con.prepareStatement(sql);
           ps.setString(1,user.getUsername());
           rs=ps.executeQuery();
           while( rs.next()){
               if(rs.getInt(1)>0) throw new shopException("添加的用户已经存在");
           }
           sql="insert into l_uesr(username,password,neckname,stadio,typle) value(?,?,?,?,?)";
           ps=con.prepareStatement(sql);
           ps.setString(1,user.getUsername());
           ps.setString(2,user.getPassword());
           ps.setString(3,user.getNeckname());
           ps.setInt(4,0);
           ps.setInt(5,0);
           ps.executeUpdate();
       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           Dbconnecton.close(con);
           Dbconnecton.close(ps);
           Dbconnecton.close(rs);
       }

    }
    @Test
    public void test(){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {

            User user = new User();
            user.setNeckname("12213");
            user.setUsername("123");
            user.setPassword("123412312");
            con= Dbconnecton.getconnection();
            String sql="select count(*) from L_uesr where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            rs=ps.executeQuery();
            while( rs.next()){
                if(rs.getInt(1)>0) throw new shopException("添加的用户已经存在");
            }
            sql="insert into l_uesr(username,password,neckname) value(?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNeckname());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);
            Dbconnecton.close(rs);
        }

    }

    @Override
    public void delete(int id) {
                Connection con=null;
                PreparedStatement ps=null;
           User u=this.load(id);
        if(u.getUsername().equals("admin"))throw new shopException("超级管理员不可以被删除");
        try {
            con=Dbconnecton.getconnection();
            String sql="delete from L_uesr where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
      e.printStackTrace();
        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);

        }


    }

    @Test
    public void textdelete() {
        Connection con=null;
        PreparedStatement ps=null;
        User u=this.load(50);
        if(u.getUsername().equals("admin"))throw new shopException("超级管理员不可以被删除");
        try {
            con=Dbconnecton.getconnection();
            String sql="delete from L_uesr where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,50);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);

        }


    }


    @Test
public void textupdate(){
        Connection con=null;
        PreparedStatement ps=null;
        User user=new User();

        try { user.setId(9);
            user.setPassword("1243");
            user.setNeckname("dddd");
            con=Dbconnecton.getconnection();
            String sql="update l_uesr set password=?,neckname=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getNeckname());

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);

        }

    }


    @Override
    public void update(User user) {
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=Dbconnecton.getconnection();
            String sql="update l_uesr set password=?,neckname=?,stadio=?,typle=? where id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getPassword());
            ps.setString(2,user.getNeckname());
            ps.setInt(3,user.getStadio());
            ps.setInt(4,user.getType());
            ps.setInt(5,user.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);

        }


    }

    @Override
    public User load(int id) {
              Connection con=null;
              PreparedStatement ps=null;
              ResultSet rs=null;
              User u=null;
        try {
            con=Dbconnecton.getconnection();
            String sql="select *from l_uesr where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                u=new User();
                u.setId(rs.getInt("id"));
                u.setStadio(rs.getInt("stadio"));
                u.setType(rs.getInt("typle"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setNeckname(rs.getString("neckname"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);
            Dbconnecton.close(rs);
        }


        return u;
    }

    @Override
    public List<User> list(String contion) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User u=null;
      
        List<User> users=new ArrayList<User>();
       try {
           int totalRecod=0;
           con=Dbconnecton.getconnection();
           String  sql = "select * from l_uesr";

           if(contion==null||"".equals(contion))
           {
               ps = con.prepareStatement(sql);
           }
           else  {
               sql=sql+" where username like ? or neckname like ? ";
               ps = con.prepareStatement(sql);
               ps.setString(1,"%"+contion+"%");
               ps.setString(2,"%"+contion+"%");

           }
           rs=ps.executeQuery();
           while(rs.next()){
               u=new User();
               u.setId(rs.getInt("id"));
               u.setStadio(rs.getInt("stadio"));
               u.setType(rs.getInt("typle"));
               u.setUsername(rs.getString("username"));
               u.setNeckname(rs.getString("neckname"));
               u.setPassword(rs.getString("password"));
               users.add(u);
           }
         
       }catch (SQLException e){
           e.printStackTrace();
       }
       finally {
           Dbconnecton.close(con);
           Dbconnecton.close(ps);
           Dbconnecton.close(rs);
       }

       
        return users;
    }

    @Override
    public User login(String username, String password) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User u = null;
        try {
            con=Dbconnecton.getconnection();
            String sql="select * from l_uesr where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,username);
            rs=ps.executeQuery();
            while(rs.next()){
                u=new User();
                u.setId(rs.getInt("id"));
                u.setStadio(rs.getInt("stadio"));
                u.setType(rs.getInt("typle"));
                u.setNeckname(rs.getString("neckname"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));

            }
           if (u==null) throw new shopException("用户名不存在");
          if(!u.getPassword().equals(password)) throw new shopException("密码错误");
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);
            Dbconnecton.close(rs);
        }

        return u;
    }


}
