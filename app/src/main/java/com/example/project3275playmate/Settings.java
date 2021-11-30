package com.example.project3275playmate;

import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Settings extends AppCompatActivity {
    EditText newEmail,newPassword,newName;
    Button changeSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        newEmail = findViewById(R.id.newEmail);
        newPassword = findViewById(R.id.newPassword);
        newName = findViewById(R.id.newName);

        changeSetting = findViewById(R.id.changeSetting);

    }
}