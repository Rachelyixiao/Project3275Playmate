package com.example.project3275playmate;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.RegisterLogin.LoginPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.jetbrains.annotations.NotNull;

public class BottomNavActivity extends AppCompatActivity {
    private BottomNavigationView btmNavView;
    private TextView btnNavTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);







        //Bottom navigation bar
        btmNavView = findViewById(R.id.bottom_navigation_bar);
        btnNavTextView = findViewById(R.id.text_message);





        btmNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        btnNavTextView.setText(R.string.title_home);
                        return true;
                    case R.id.navigation_contact:
                        btnNavTextView.setText(R.string.title_contact);
                        return true;
                    case R.id.navigation_settings:
                        btnNavTextView.setText(R.string.title_settings);
                        return true;
                }
                return false;
            }
        });


    }
}