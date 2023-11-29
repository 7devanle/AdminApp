package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.adminapp.activity.RegisterStudent;
import com.example.adminapp.activity.ViewAllStudent;
//import com.example.adminapp.data.AdminViewModel;
import com.example.adminapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //AdminViewModel avm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

      //  avm = new ViewModelProvider(this).get(AdminViewModel.class);

        binding.registerStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RegisterStudent.class);
                startActivity(intent);
            }
        });

        binding.viewStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ViewAllStudent.class);
                startActivity(intent);
            }
        });
    }
}
