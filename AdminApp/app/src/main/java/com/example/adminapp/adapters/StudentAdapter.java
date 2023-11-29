//package com.example.adminapp.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.adminapp.R;
//import com.example.adminapp.data.AdminViewModel;
//import com.example.adminapp.databinding.ActivityStudentLayoutBinding;
//import com.example.adminapp.entities.Student;
//
//import java.util.List;
//
//public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
//
//    Context context;
//    List<Student> students;
//    ActivityStudentLayoutBinding binding;
//
//    public StudentAdapter(Context context, AdminViewModel adminViewModel) {
//        this.context = context;
//        this.students = adminViewModel.getAllStudents().getValue();
//    }
//
//    @NonNull
//    @Override
//    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_student_layout, parent, false));
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
//        holder.nameView.setText(students.get(position).getName());
//        holder.locationView.setText(students.get(position).getLocation());
//        holder.departmentView.setText(students.get(position).getDepartment());
//        holder.facultyView.setText(students.get(position).getFaculty());
//        holder.imageView.setImageResource(R.drawable.face);
//    }
//
//    @Override
//    public int getItemCount() {
//        return students.size();
//    }
//}
