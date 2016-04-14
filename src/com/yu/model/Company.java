package com.yu.model;

/**
 * Created by lenovo on 2016/4/14.
 */
public class Company {
    private int id;
    private  double Rate;
    private  String companyname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
