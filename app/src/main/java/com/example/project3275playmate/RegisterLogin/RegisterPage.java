package com.example.project3275playmate.RegisterLogin;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Classes.User;
import com.example.project3275playmate.DAO.Connection;
import com.example.project3275playmate.DAO.DAO_Implementation;
import com.example.project3275playmate.DAO.MainMethods;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class RegisterPage extends AppCompatActivity {
    TextView getName, getEmail, getPassword;
    String name, email, password, toast;
    ImageView registerNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        getName = findViewById(R.id.getUserName);
        getEmail = findViewById(R.id.getEmail);
        getPassword = findViewById(R.id.getPassword);
        registerNow = findViewById(R.id.registerNow);
    }

    public void selection(View view) {
        int choice = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.customer:
                if (checked){
                    choice = 0;
                    Toast.makeText(this, "You have selected to be a customer",Toast.LENGTH_LONG).show();
                }
            case R.id.expert:
                if (checked){
                    choice = 1;
                    Toast.makeText(this, "You have selected to be an expert",Toast.LENGTH_LONG).show();
                }
        }
    }

    public void register(View view) throws SQLException, ClassNotFoundException {
        name = getName.getText().toString();
        email = getEmail.getText().toString();
        password = getPassword.getText().toString();

        MainMethods mm = new MainMethods();
        toast = mm.register(name, email, password);
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();

    }
}