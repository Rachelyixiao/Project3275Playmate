package com.example.project3275playmate.RegisterLogin;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class LoginPage extends AppCompatActivity {
    EditText emailLogin;
    EditText pwLogin;
    TextView resetPw;
    Button btnLoginSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        emailLogin = findViewById(R.id.nameLogin);
        pwLogin = findViewById(R.id.pwLogin);
        resetPw = findViewById(R.id.resetPw);
        btnLoginSubmit = findViewById(R.id.btnLoginSubmit);
    }
}