package com.yu.model;

/**
 * Created by lenovo on 2016/4/13.
 */
public class User {
    private String username;
    private int id;
    private String password;
    private String neckname;
    private int stadio;

    public int getStadio() {
        return stadio;
    }

    public void setStadio(int stadio) {
        this.stadio = stadio;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int type;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNeckname() {
        return neckname;
    }

    public void setNeckname(String neckname) {
        this.neckname = neckname;
    }
}
