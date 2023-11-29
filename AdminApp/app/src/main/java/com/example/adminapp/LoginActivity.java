package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.adminapp.data.AdminViewModel;
import com.example.adminapp.databinding.ActivityLoginBinding;
import com.example.adminapp.entities.Admin;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    AdminViewModel avm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        avm = new ViewModelProvider(this).get(AdminViewModel.class);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                String username = binding.username.getText().toString().trim();
                String password = binding.passwordtext.getText().toString().trim();
                Admin admin = new Admin(username, password);
                if(avm.login(admin).equals("logged")){
                    startActivity(intent);
                }else{
                    binding.username.setText("");
                    binding.passwordtext.setText("");
                    Toast.makeText(LoginActivity.this, "Kindly check admin details again", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}