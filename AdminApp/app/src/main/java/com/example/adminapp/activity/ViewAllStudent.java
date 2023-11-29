package com.example.adminapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.adminapp.R;
//import com.example.adminapp.adapters.StudentAdapter;
//import com.example.adminapp.data.AdminViewModel;
import com.example.adminapp.databinding.ActivityCycleStudentBinding;
import com.example.adminapp.entities.Student;

import java.util.List;

public class ViewAllStudent extends AppCompatActivity {
    ActivityCycleStudentBinding binding;
    //AdminViewModel avm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = binding.recyclerView;
//        avm = new ViewModelProvider(this).get(AdminViewModel.class);
//
//        List<Student> students = avm.getAllStudents().getValue();
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new StudentAdapter(getApplicationContext(), (AdminViewModel) students));

    }
}