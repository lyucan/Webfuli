package com.yu.Dao;

import com.yu.model.Number;

/**
 * Created by lenovo on 2016/4/13.
 */
public interface Inumberdao {
    public void add(Number number,int userid);
    public void update(Number number ,int userid);
    public void delete(int id);
    public Number load(int id);

}
