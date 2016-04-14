package com.yu.Dao;

import com.yu.model.Company;

import java.util.List;

/**
 * Created by lenovo on 2016/4/14.
 */
public interface Icompany {
    public void add(Company company);
    public void update(Company company);
    public void delete(int id);
    public Company load(int id);
    public List<Company> list(String contion);



}
