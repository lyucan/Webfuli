package com.yu.model;

/**
 * Created by lenovo on 2016/4/13.
 */
public class Number {
    private double FuterMoney;
    private int id;
    private double NonMoney;
    private double  Rate;
    private int Year;

    public double getFuterMoney() {
        return FuterMoney;
    }

    public void setFuterMoney(double futerMoney) {
        FuterMoney = futerMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNonMoney() {
        return NonMoney;
    }

    public void setNonMoney(double nonMoney) {
        NonMoney = nonMoney;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private int userid;



}
