package com.example.project3275playmate;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.DAO.DAO;

public class Settings extends AppCompatActivity {
    EditText newEmail,newPassword,currentPsw;
    Button changeSetting;
    SharedPreferences sp;
   String psw,sCurrentPsw,snewEmail,snewPassword;
String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        DAO dao = new DAO(this);
        newEmail = findViewById(R.id.newEmail);
        newPassword = findViewById(R.id.newPassword);
        currentPsw = findViewById(R.id.currentPsw);
        sp = getSharedPreferences("user", Context.MODE_PRIVATE) ;
        name = sp.getString("user","");
        changeSetting = findViewById(R.id.changeSetting);
        psw = dao.getPassword(name);
        changeSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sCurrentPsw = currentPsw.getText().toString();
                snewEmail = newEmail.getText().toString();
                snewPassword = newPassword.getText().toString();
                if (psw == sCurrentPsw){
                    if (dao.updateUserData(name,snewPassword,snewEmail)){
                        Toast.makeText(Settings.this,"Change saved",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(Settings.this,"Change not saved",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}