package com.example.adminapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.adminapp.entities.Admin;

import java.util.List;

@Dao

public interface AdminDao{
    @Insert
    void insert(Admin admin);

    @Update
    void update(Admin admin);
    @Delete
    void delete(Admin admin);

    @Query("DELETE FROM admins")
    void deleteAllAdmins();

    @Query("SELECT * FROM admins ORDER BY username DESC")
    LiveData<List<Admin>> getAllAdmins();

    @Query("SELECT * FROM admins WHERE username = :admin_name LIMIT 1")
    LiveData<Admin> getAdmin(String admin_name);

    @Query("SELECT * FROM admins WHERE admin_ids = :id LIMIT 1")
    LiveData<Admin> getAdmin(int id);

}
