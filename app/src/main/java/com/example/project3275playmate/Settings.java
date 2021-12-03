package com.example.project3275playmate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Classes.User;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.Homepage.ExpertMainPage;
import com.example.project3275playmate.RegisterLogin.LoginPage;

import java.sql.SQLException;

public class Settings extends AppCompatActivity {
    EditText newEmail,newPassword,currentPsw;
    Button changeSetting;
    SharedPreferences sp;
    String psw, sCurrentPsw, sNewEmail, sNewPassword, name, toast;
    User user;
    DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        dao = new DAO(this);
        newEmail = findViewById(R.id.newEmail);
        newPassword = findViewById(R.id.newPassword);
        currentPsw = findViewById(R.id.currentPsw);

        sp = getSharedPreferences("user", Context.MODE_PRIVATE) ;
        name = sp.getString("name","defaultName");

        changeSetting = findViewById(R.id.changeSetting);
        try {
            user = dao.searchUser(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        psw = user.getPassword();
    }

    public void submitChange(View view) throws SQLException, ClassNotFoundException {
        sCurrentPsw = currentPsw.getText().toString();
        sNewEmail = newEmail.getText().toString();
        sNewPassword = newPassword.getText().toString();

        toast = dao.editInfo(name, sCurrentPsw, sNewPassword, sNewEmail);
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Settings.this, LoginPage.class));
    }
}