package com.example.adminapp.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "admins")
public class Admin {
    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "admin_ids")
    private int id;
    @NotNull
    @ColumnInfo(name = "username")
    private String username;
    @NotNull
    @ColumnInfo(name = "password")
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String previousPassword, String password) {
        if(this.password == previousPassword)
            this.password = password;
        else
            System.out.println("Wrong password");
    }


}
