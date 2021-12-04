package com.example.project3275playmate;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.RegisterLogin.LoginPage;
import com.example.project3275playmate.RegisterLogin.RegisterPage;

public class MainActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            DataBase db = new DataBase(this);
            db.getWritableDatabase();

            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }

            Button btnMainPageLogin = findViewById(R.id.login);
            Button btnMainPageRegister = findViewById(R.id.register);

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



    }







}