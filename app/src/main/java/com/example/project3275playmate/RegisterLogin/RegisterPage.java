package com.example.project3275playmate.RegisterLogin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Classes.User;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.DAO.MainMethods;
import com.example.project3275playmate.MainActivity;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class RegisterPage extends AppCompatActivity {
    TextView getName, getEmail, getPassword;
    String name, email, password, toast;
    Button butCus, butExpert;
    ImageView registerNow;
    int choice = 0;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        getName = findViewById(R.id.getUserName);
        getEmail = findViewById(R.id.getEmail);
        getPassword = findViewById(R.id.getPassword);
        registerNow = findViewById(R.id.registerNow);
        butCus = findViewById(R.id.customer);
        butExpert = findViewById(R.id.expert);

        sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void selection(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.customer:
                if (checked){
                    choice = 1;
                    Toast.makeText(this, "You have selected to be a customer",Toast.LENGTH_SHORT).show();
                }
            case R.id.expert:
                if (checked){
                    choice = 2;
                    Toast.makeText(this, "You have selected to be an expert",Toast.LENGTH_SHORT).show();
                }
        }
    }

    public void register(View view){
        DAO dao = new DAO(this);
        name = getName.getText().toString().trim();
        email = getEmail.getText().toString().trim();
        password = getPassword.getText().toString().trim();

        if (choice == 0){
            Toast.makeText(this, "Please select to be Customer or Expert.", Toast.LENGTH_LONG).show();
            return;
        };
        try {
            toast = dao.register(name, email, password, choice);
            editor.putString("name", name);
            editor.commit();
            Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
            if (!toast.contains("Register Successful!")){
                return;
            }
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }
        if (choice==1){
            startActivity(new Intent(RegisterPage.this, LoginPage.class));
        }
        else if (choice==2){
            startActivity(new Intent(RegisterPage.this, ExpertRegisterPage.class));
        }

    }
}