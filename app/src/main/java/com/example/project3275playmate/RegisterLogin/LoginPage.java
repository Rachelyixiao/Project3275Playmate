package com.example.project3275playmate.RegisterLogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class LoginPage extends AppCompatActivity {
    EditText nameLogin;
    EditText pwLogin;
    TextView resetPw;
    Button btnLoginSubmit;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    String toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        nameLogin = findViewById(R.id.nameLogin);
        pwLogin = findViewById(R.id.pwLogin);
        resetPw = findViewById(R.id.resetPw);
        btnLoginSubmit = findViewById(R.id.btnLoginSubmit);
        sp = getSharedPreferences("user", Context.MODE_PRIVATE); //Save data to the next pages
        editor = sp.edit();
    }

    public void login(View view){
        DAO dao = new DAO(this);
        String name = nameLogin.getText().toString().trim();
        String password = pwLogin.getText().toString().trim();
        try {
            toast = dao.login(name, password);
            editor.putString("name", name);
            editor.commit();
            Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
            if (!toast.contains("Register Successful!")){
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}