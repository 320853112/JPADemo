package com.xu.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "test1")
public class User {

    @Id
    private String username;

    @Column
    private String password;

    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
