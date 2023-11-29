package com.example.adminapp.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.databinding.ActivityStudentLayoutBinding;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    ActivityStudentLayoutBinding binding;
    ImageView imageView;
    TextView nameView, locationView, departmentView, facultyView;
    public StudentViewHolder(@NonNull View studentView) {
        super(studentView);
        imageView= binding.image;
        nameView = binding.name;
        locationView = binding.location;
        departmentView = binding.department;
        facultyView = binding.faculty;
    }
}
