package com.sy.beans;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Order
{
    private Long id;
    private Menu menu;
    private User user;
    private Admin admin;
    //    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;
    private Long state;

    public Order(Long id, Menu menu, User user, Admin admin, Date date, Long state) {
        this.id = id;
        this.menu = menu;
        this.user = user;
        this.admin = admin;
        this.date = date;
        this.state = state;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", menu=" + menu +
                ", user=" + user +
                ", admin=" + admin +
                ", date=" + date +
                ", state=" + state +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }
}
