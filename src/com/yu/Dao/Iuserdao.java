package com.yu.Dao;

import com.yu.model.User;

import java.util.List;

/**
 * Created by lenovo on 2016/4/7.
 */
public interface Iuserdao {
      public void add(User user);
      public void delete(int id);
      public void update(User user);
      public User load(int id);
      public List<User> list(String contion);
      public User login(String username, String password);

}
