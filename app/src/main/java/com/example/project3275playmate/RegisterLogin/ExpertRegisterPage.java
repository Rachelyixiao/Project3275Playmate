package com.example.project3275playmate.RegisterLogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Classes.Expert;
import com.example.project3275playmate.Classes.User;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class ExpertRegisterPage extends AppCompatActivity {
    Spinner getGameListProfile;
    RadioGroup chooseGender, addProfileNowOption;
    RadioButton genderGirl, genderBoy, addProfileYes, addProfileNo;
    String gender = "", name, toast;
    int choice;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_register_page);
        getGameListProfile = findViewById(R.id.getGamelistProfile);
        addProfileNo = findViewById(R.id.addProfileNo);
        addProfileYes = findViewById(R.id.addProfileYes);

        sp = getSharedPreferences("user", Context.MODE_PRIVATE);

    }

    public void selectionGender(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.genderBoy:
                if (checked){
                    gender = "Boy";
                }
            case R.id.genderGirl:
                if (checked){
                    gender = "Girl";
                }
        }
    }

    public void selectionUpload(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.addProfileYes:
                if (checked){
                    startActivity(new Intent(ExpertRegisterPage.this, LoginPage.class));
                }
            case R.id.addProfileNo:
                if (checked){
                    gender = "Girl";
                    startActivity(new Intent(ExpertRegisterPage.this, LoginPage.class));
                }
        }
    }

    public void submit(View view) {
        DAO dao = new DAO(this);
        //Get User expert
        name = sp.getString("name", "defaultName");
        try {
            User user = dao.searchUser(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (gender.equals("")){
            Toast.makeText(this, "Please select your gender.", Toast.LENGTH_SHORT).show();
            return;
        };

        try {
            toast = dao.expertAddingInfo(name, gender);
            Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }


}