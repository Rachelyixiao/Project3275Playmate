package com.example.project3275playmate.RegisterLogin;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class ExpertRegisterPage extends AppCompatActivity {
    Spinner getGamelistProfile;
    RadioGroup chooseGender,addProfileNowOption;
    RadioButton genderGirl,genderBoy,addProfileYes,addProfileNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_register_page);
        getGamelistProfile = findViewById(R.id.getGamelistProfile);
        genderBoy = findViewById(R.id.genderBoy);
        genderGirl = findViewById(R.id.genderGirl);
        addProfileNo=findViewById(R.id.addProfileNo);
        addProfileYes=findViewById(R.id.addProfileYes);

    }
}