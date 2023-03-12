package com.wqm.ims.bean;

import lombok.Data;

@Data
public class User {
    private String phone;
    private String password;
    private Integer role;

    public User() {
    }

    public User(String phone, String password, Integer role) {
        this.phone = phone;
        this.password = password;
        this.role = role;
    }
}
