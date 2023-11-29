package com.example.adminapp.data;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.adminapp.dao.AdminDao;
import com.example.adminapp.entities.Admin;
import com.example.adminapp.entities.Student;

import java.util.List;

public class Repository {
    AdminDao adminDao;
    private LiveData<List<Admin>> allAdmins;
    public Repository(Application application) {
        AdminDatabase adminDatabase = AdminDatabase.getInstance(application);
        //studentDao = adminDatabase.studentDao();
        adminDao = adminDatabase.adminDao();
        allAdmins = adminDao.getAllAdmins();

    }

    public void insertAdmin(Admin admin) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.insert(admin));
    }

    public String login(Admin admin) {
        //Log.i("ADMINS", getAllAdmins().getValue().toString());;
        Admin availableAdmin = adminDao.getAdmin(admin.getUsername()).getValue();
        if (availableAdmin != null && admin.getPassword().equals(availableAdmin.getPassword())) {
            return "logged";
        }
        return "incorrect";
    }

    public void update(Admin admin) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.update(admin));
    }

    public void delete(Admin admin) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.delete(admin));
    }

    public LiveData<List<Admin>> getAllAdmins(){
        return allAdmins;
    }

    public LiveData<Admin> getAdmin(String admin_name) {
        return adminDao.getAdmin(admin_name);
    }

    public LiveData<Admin> getAdmin(int adminId) {
        return adminDao.getAdmin(adminId);
    }

    public void insert(Student student) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.insert(student));
    }

    public void update(Student student) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.update(student));
    }

    public void delete(Student student) {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.delete(student));
    }

    public void blacklist(Student student){
        student.setBlackList();
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.update(student));
    }

    public void deleteAllStudents() {
        AdminDatabase.DATABASE_WRITE_EXECUTOR.execute(() -> adminDao.deleteAllStudents());
    }

    public LiveData<List<Student>> getAllStudents() {
        return adminDao.getAllStudents();
    }

    public LiveData<List<Student>> getBlacklisted() {
        return adminDao.getBlacklisted();
    }

    public LiveData<List<Student>> getNonBlacklisted() {
        return adminDao.getNonBlacklisted();
    }

    public LiveData<Student> getStudent(String student_mat) {
        return adminDao.getStudent(student_mat);
    }

    public LiveData<Student> searchStudent(String query) {
        return adminDao.searchStudent(query);
    }

    public LiveData<Student> getStudent(int id) {
        return adminDao.getStudent(id);
    }

}
