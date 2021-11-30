package com.example.project3275playmate;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Classes.*;
import com.example.project3275playmate.DAO.Connection;
import com.example.project3275playmate.DAO.DAO_Implementation;
import com.example.project3275playmate.RegisterLogin.LoginPage;
import com.example.project3275playmate.RegisterLogin.RegisterPage;

import java.sql.SQLException;
import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button btnMainPageLogin = findViewById(R.id.btnLogin);
            Button btnMainPageRegister = findViewById(R.id.btnRegister);

            //Test nav, can delete later
            Button btnTestNav =findViewById(R.id.btnTestNav);

            btnMainPageLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, LoginPage.class));
                }
            });

            btnMainPageRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, RegisterPage.class));
                }
            });

            btnTestNav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,BottomNavActivity.class));
                }
            });
    }







}