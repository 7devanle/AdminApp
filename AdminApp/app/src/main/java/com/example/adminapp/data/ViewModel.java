package com.example.adminapp.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.adminapp.entities.Admin;
import com.example.adminapp.entities.Student;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    Repository adminRepository;
    private LiveData<List<Admin>> allAdmins;
    public ViewModel(@NonNull Application application) {
        super(application);
        adminRepository = new Repository(application);
        allAdmins = adminRepository.getAllAdmins();
    }

    public LiveData<List<Admin>> getAllAdmins(){
        return allAdmins;
    }

    public String login(Admin admin){
        return adminRepository.login(admin);
    }

    public void update(Admin admin) {
        adminRepository.update(admin);
    }

    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

    public LiveData<Admin> getAdmin(String admin_name) {
        return adminRepository.getAdmin(admin_name);
    }

//    public LiveData<Admin> getAdmin(int adminId) {
//        return adminRepository.getAdmin(adminId);
//    }

    public void insert(Student student) {
        adminRepository.insert(student);
    }

    public void update(Student student) {
        adminRepository.update(student);
    }

    public void delete(Student student) {
        adminRepository.delete(student);
    }

    public void deleteAllStudents() {
        adminRepository.deleteAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return adminRepository.getAllStudents();
    }

    public LiveData<List<Student>> getBlacklisted(){
        return adminRepository.getBlacklisted();
    }

    public LiveData<List<Student>> getNonBlacklisted(){
        return adminRepository.getNonBlacklisted();
    }

    public LiveData<Student> getStudent(String student_mat) {
        return adminRepository.getStudent(student_mat);
    }

    public LiveData<Student> searchStudent(String query) {
        return adminRepository.searchStudent(query);
    }

    public LiveData<Student> getStudent(int id) {
        return adminRepository.getStudent(id);
    }

}

