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
    RadioGroup chooseGender,addProfileNowOption;
    RadioButton genderGirl,genderBoy,addProfileYes,addProfileNo;
    String gender = "", name, toast;
    int choice;

    SharedPreferences sp = getSharedPreferences("user", Context.MODE_PRIVATE);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_register_page);
        getGameListProfile = findViewById(R.id.getGamelistProfile);
        genderBoy = findViewById(R.id.genderBoy);
        genderGirl = findViewById(R.id.genderGirl);
        addProfileNo = findViewById(R.id.addProfileNo);
        addProfileYes = findViewById(R.id.addProfileYes);

    }

    public void selection(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.genderBoy:
                if (checked){
                    gender = "Boy";
                }
            case R.id.genderGirl:
                if (checked){
                    choice = 2;
                    gender = "Girl";
                }
        }
    }

    public void submit(View view){
        DAO dao = new DAO(this);
        //Get User expert
        name = sp.getString("name", "defaultName");
        try {
            User expert = dao.searchUser(name);
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