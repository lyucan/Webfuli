package com.yu.Dao;

import com.yu.Dbuntil.Dbconnecton;
import com.yu.model.Number;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lenovo on 2016/4/13.
 */

public class Numberdao implements Inumberdao{
    @Override
    public void add(Number number,int userid) {
        Connection con=null;
        PreparedStatement ps=null;

    try {
    con= Dbconnecton.getconnection();
    String sql="insert into l_number(userid,NonMoney,Rate,Year,FuterMoney,id) value(?,?,?,?,?,?) ";
    ps=con.prepareStatement(sql);
        ps.setInt(1,userid);
        ps.setDouble(2,number.getNonMoney());
        ps.setDouble(3,number.getRate());
        ps.setInt(4,number.getYear());
        ps.setDouble(5,number.getFuterMoney());
        ps.setInt(6,number.getId());
        ps.executeUpdate();
    }catch (SQLException e){
        e.printStackTrace();

    }
        finally {
        Dbconnecton.close(con);
        Dbconnecton.close(ps);

    }
    }

    @Override
    public void update(Number number,int userid) {
        Connection con=null;
        PreparedStatement ps=null;
  try {
      con=Dbconnecton.getconnection();
      String sql="update l_number set NonMoney=?,Rate=?,Year=?,FuterMoney=? where id=?";
      ps=con.prepareStatement(sql);
      ps.setDouble(1,number.getNonMoney());
      ps.setDouble(2,number.getRate());
      ps.setInt(3,number.getYear());
      ps.setDouble(4,number.getFuterMoney());
      ps.setInt(5,number.getId());
      ps.executeUpdate();

  }catch (SQLException e){
      e.printStackTrace();

  }
  finally {
      Dbconnecton.close(con);
      Dbconnecton.close(ps);

  }
    }

    @Override
    public void delete(int id) {
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=Dbconnecton.getconnection();
            String sql="delete from L_number where id=?";
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
    public void testdelete(){
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=Dbconnecton.getconnection();
            String sql="delete from L_number where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,40);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();

        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);

        }

    }

    @Override
    public Number load(int id) {
        Number number=null;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=Dbconnecton.getconnection();
            String sql="select * from l_number where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                number=new Number();
                number.setFuterMoney(rs.getDouble("FuterMoney"));
                number.setId(rs.getInt("id"));
                number.setNonMoney(rs.getDouble("NonMoney"));
                number.setRate(rs.getDouble("Rate"));
                number.setUserid(rs.getInt("userid"));
                number.setYear(rs.getInt("Year"));

            }


        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);
            Dbconnecton.close(rs);
        }

        return number;
    }
}
