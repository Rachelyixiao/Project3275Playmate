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
import com.example.project3275playmate.Homepage.ExpertMainPage;
import com.example.project3275playmate.R;
import com.example.project3275playmate.UploadPages.AddProfiles;

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
                    choice = 1;
                }
            case R.id.addProfileNo:
                if (checked){
                    choice = 2;
                }
        }
    }

    public void submit(View view) {
        DAO dao = new DAO(this);
        //Get User expert
        name = sp.getString("name", "defaultName");

        if (gender.equals("")){
            Toast.makeText(this, "Please select your gender.", Toast.LENGTH_SHORT).show();
            return;
        };

        try {
            toast = dao.expertAddingInfo(name, gender);
            Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }

        if (choice == 1){
            startActivity(new Intent(ExpertRegisterPage.this, AddProfiles.class));
        }
        else if (choice == 2){
            startActivity(new Intent(ExpertRegisterPage.this, ExpertMainPage.class));
        }

    }


}