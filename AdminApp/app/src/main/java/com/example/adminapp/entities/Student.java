package com.example.adminapp.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "students")
public class Student {

    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    private int id;
    @NotNull
    @ColumnInfo(name = "mat")
    private String matNo;
    @NotNull
    @ColumnInfo(name = "name")
    private String name;
    private int photo;
    @NotNull
    private String location;
    @NotNull
    private String department;
    @NotNull
    private String faculty;

    private int blackListed;

    public void setBlackListed(int blackListed) {
        this.blackListed = blackListed;
    }

    public Student(String name, String location, int photo, String department, String faculty) {
        this.matNo = "SOOL"+getId();
        this.name = name;
        this.location = location;
        this.photo = photo;
        this.department = department;
        this.faculty = faculty;
        this.blackListed = 0;
    }

    @Ignore
    public Student(int id, String name, int photo, String location, String department, String faculty) {
        this.id=id;
        this.matNo = "SOOL"+getId();
        this.name = name;
        this.location = location;
        this.photo = photo;
        this.department = department;
        this.faculty = faculty;
        this.blackListed = 0;
    }
    public void setBlackList(){
        if(this.blackListed == 1)
            this.blackListed = 0;
        else
            this.blackListed = 1;
    }

    public int getId() {
        return id;
    }

    public String getMatNo() {
        return this.matNo;
    }

    public void setMatNo(String matNo) {
        this.matNo = matNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return this.photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public int getBlackListed() {
        return blackListed;
    }

}

