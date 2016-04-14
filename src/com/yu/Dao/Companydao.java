package com.yu.Dao;

import com.yu.Dbuntil.Dbconnecton;
import com.yu.model.Company;
import com.yu.model.shopException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/4/14.
 */
public class Companydao implements Icompany{
    @Override
    public void add(Company company) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con= Dbconnecton.getconnection();
            String sql="select count(*) from L_uesr where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,company.getCompanyname());
            rs=ps.executeQuery();
            while( rs.next()){
                if(rs.getInt(1)>0) throw new shopException("添加的用户已经存在");
            }
            sql="insert into l_company(id,companyname,Rate) value(?,?,?) ";
            ps=con.prepareStatement(sql);
            ps.setInt(1,company.getId());
           ps.setString(2,company.getCompanyname());
            ps.setDouble(3,company.getRate());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();

        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);
            Dbconnecton.close(rs);
        }
    }

    @Override
    public void update(Company company) {
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=Dbconnecton.getconnection();
            String sql="update l_company set companyname=?,Rate=? where id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,company.getCompanyname());
            ps.setDouble(2,company.getRate());
            ps.setInt(3,company.getId());
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
    public void delete(int id) {
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=Dbconnecton.getconnection();
            String sql="delete from l_company where id=?";
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

    @Override
    public Company load(int id) {
        Company company =null;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            con=Dbconnecton.getconnection();
            String sql="select *from l_company where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                company=new Company();
                company.setId(rs.getInt("id"));
                company.setCompanyname(rs.getString("companyname"));
                company.setRate(rs.getDouble("Rate"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);
            Dbconnecton.close(rs);
        }



        return company;
    }

    @Override
    public List<Company> list(String contion) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Company company=null;
        List<Company> companies=new ArrayList<Company>();
        try {
            con=Dbconnecton.getconnection();
            String sql = "select * from l_company";
            if(contion==null||"".equals(contion))
            {
                ps = con.prepareStatement(sql);
            }
            else  {
                sql+=" where username like ? or neckname like ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1,"%"+contion+"%");
                ps.setString(2,"%"+contion+"%");
            }
            rs=ps.executeQuery();
            while(rs.next()){
                company=new Company();
                company.setId(rs.getInt("id"));
                company.setCompanyname(rs.getString("companyname"));
                company.setRate(rs.getDouble("Rate"));
                companies.add(company);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            Dbconnecton.close(con);
            Dbconnecton.close(ps);
            Dbconnecton.close(rs);
        }



        return companies;
    }
}
