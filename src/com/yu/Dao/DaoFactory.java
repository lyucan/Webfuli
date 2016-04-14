package com.yu.Dao;

/**
 * Created by lenovo on 2016/4/7.
 */
public class DaoFactory {
    public static Iuserdao getuserdao(){

        return new Userdao();
    }
    public static  Inumberdao getnumberdao(){

        return new Numberdao();
    }
    public static  Companydao getcompanydao(){

        return new Companydao();
    }
}
