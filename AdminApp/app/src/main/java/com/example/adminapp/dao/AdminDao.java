package com.example.adminapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.adminapp.entities.Admin;
import com.example.adminapp.entities.Student;

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

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);
    @Delete
    void delete(Student student);

    @Query("DELETE FROM students")
    void deleteAllStudents();

    @Query("SELECT * FROM students ORDER BY mat DESC")
    LiveData<List<Student>> getAllStudents();

    @Query("SELECT * FROM students WHERE blackListed = 1 ORDER BY mat DESC")
    LiveData<List<Student>> getBlacklisted();

    @Query("SELECT * FROM students WHERE blackListed = 0 ORDER BY mat DESC")
    LiveData<List<Student>> getNonBlacklisted();

    @Query("SELECT * FROM students WHERE mat = :student_mat LIMIT 1")
    LiveData<Student> getStudent(String student_mat);

    @Query("SELECT * FROM students WHERE mat like '%' || :query || '%' ")
    LiveData<Student> searchStudent(String query);

    @Query("SELECT * FROM students WHERE student_id = :id LIMIT 1")
    LiveData<Student> getStudent(int id);


}
