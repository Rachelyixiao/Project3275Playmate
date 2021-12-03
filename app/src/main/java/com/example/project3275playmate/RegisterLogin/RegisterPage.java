package com.example.project3275playmate.RegisterLogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class RegisterPage extends AppCompatActivity {
    TextView getName, getEmail, psw1,psw2;
    String name, email, password, toast;
    ImageView registerNow;
    String sName,sEmail,sPsw1,sPsw2;
    RadioButton Rdo;
    int choice = 0;
    SharedPreferences user = getSharedPreferences("user",MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        getName = findViewById(R.id.getUserName);
        getEmail = findViewById(R.id.getEmail);
        psw1 = findViewById(R.id.getPassword);
        psw2 = findViewById(R.id.getPassword2);
        registerNow = findViewById(R.id.registerNow);
        Rdo = findViewById(R.id.expert);



    }

    public void selection(View view) {

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
        sName = getName.getText().toString();
        sEmail = getEmail.getText().toString();
        sPsw1 = psw1.getText().toString();
        sPsw2 = psw2.getText().toString();
        boolean checked = ((Rdo) .isChecked());
        boolean  isUnfill = sName.isEmpty()||sEmail.isEmpty()||sPsw1.isEmpty()||sPsw2.isEmpty();
        if (sPsw1.equals(sPsw2)&&!isUnfill) {
            if (checked) {

                SharedPreferences.Editor editor = user.edit();
                editor.putString("Name", sName);
                editor.putString("email", sEmail);
                editor.putString("psw", sPsw1);
                editor.commit();
                startActivity(new Intent(RegisterPage.this, ExpertRegisterPage.class));
            }
            else {
                name = sName.trim();
                email = sEmail.trim();
                password = psw1.getText().toString().trim();
                startActivity(new Intent(RegisterPage.this, LoginPage.class));
                DAO dao = new DAO(this);
                try {
                    toast = dao.registerUser(name, email, password);
                    Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }
        else if (isUnfill){
            Toast.makeText(RegisterPage.this,"The information is not completed",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(RegisterPage.this,"Password confirmation is different",Toast.LENGTH_LONG).show();
        }





    }
}