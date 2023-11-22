package com.example.adminapp.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.adminapp.dao.AdminDao;
import com.example.adminapp.dao.StudentDao;
import com.example.adminapp.entities.Admin;
import com.example.adminapp.entities.Student;

import java.util.List;

public class Repository {
    AdminDao adminDao;
    private LiveData<List<Admin>> allAdmins;
    StudentDao studentDao;

    public Repository(Application application) {
        Database database = Database.getInstance(application);
        studentDao = database.studentRepo();
        adminDao = database.adminRepo();
        allAdmins = adminDao.getAllAdmins();

    }

    public void insertAdmin(Admin admin) {
        Database.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.insert(admin));
    }

    public String login(Admin admin) {
        Admin availableAdmin = adminDao.getAdmin(admin.getUsername()).getValue();
        if (availableAdmin != null && admin.getPassword().equals(availableAdmin.getPassword())) {
            return "logged";
        }
        return "incorrect";
    }

    public void update(Admin admin) {
        Database.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.update(admin));
    }

    public void delete(Admin admin) {
        Database.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.delete(admin));
    }

    public LiveData<List<Admin>> getAllAdmins(){
        return allAdmins;
    }

    public LiveData<Admin> getAdmin(String admin_name) {
        return adminDao.getAdmin(admin_name);
    }

//    public LiveData<Admin> getAdmin(int adminId) {
//        return adminRepo.getAdmin(adminId);
//    }

    public void insert(Student student) {
        Database.DATABASE_WRITE_EXECUTOR.execute(() -> studentDao.insert(student));
    }

    public void update(Student student) {
        Database.DATABASE_WRITE_EXECUTOR.execute(() -> studentDao.update(student));
    }

    public void delete(Student student) {
        Database.DATABASE_WRITE_EXECUTOR.execute(() -> studentDao.delete(student));
    }

    public void blacklist(Student student){

    }

    public void deleteAllStudents() {
        Database.DATABASE_WRITE_EXECUTOR.execute(() -> studentDao.deleteAllStudents());
    }

    public LiveData<List<Student>> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public LiveData<List<Student>> getBlacklisted() {
        return studentDao.getBlacklisted();
    }

    public LiveData<List<Student>> getNonBlacklisted() {
        return studentDao.getNonBlacklisted();
    }

    public LiveData<Student> getStudent(String student_mat) {
        return studentDao.getStudent(student_mat);
    }

    public LiveData<Student> searchStudent(String query) {
        return studentDao.searchStudent(query);
    }

    public LiveData<Student> getStudent(int id) {
        return studentDao.getStudent(id);
    }

}
