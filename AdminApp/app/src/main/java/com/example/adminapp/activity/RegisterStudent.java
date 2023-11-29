package com.example.adminapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adminapp.R;
//import com.example.adminapp.data.AdminViewModel;
import com.example.adminapp.databinding.ActivityRegisterStudentBinding;
import com.example.adminapp.entities.Student;

public class RegisterStudent extends AppCompatActivity {

    ActivityRegisterStudentBinding binding;
    //AdminViewModel avm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterStudentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //avm = new ViewModelProvider(this).get(AdminViewModel.class);
        binding.registerStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ViewAllStudent.class);
                String name = binding.name.getText().toString().trim();
                String location = binding.location.getText().toString().trim();
                String department = binding.department.getText().toString().trim();
                String faculty = binding.faculty.getText().toString().trim();
                if(name.isEmpty() || location.isEmpty() || department.isEmpty() || faculty.isEmpty()){
                    binding.name.setText("");
                    binding.location.setText("");
                    binding.faculty.setText("");
                    binding.department.setText("");
                    Toast.makeText(RegisterStudent.this, "a field might be missing", Toast.LENGTH_SHORT).show();
                }else{
                    Student student = new Student(name, location, R.drawable.face, department, faculty);
                    //avm.insert(student);
                    Toast.makeText(RegisterStudent.this, "Student created", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

    }
}