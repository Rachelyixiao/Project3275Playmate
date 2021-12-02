package com.example.project3275playmate;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ChooseExpert extends AppCompatActivity {
    Spinner userChooseGameList;
    RadioGroup userChooseGender;
    RadioButton userChooseGirl,userChooseBoy;
    Button userChooseGameGo,userChooseGenderGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_expert);

        userChooseGameList = findViewById(R.id.userChooseGameList);
        userChooseGender = findViewById(R.id.userChooseGender);
        userChooseGirl = findViewById(R.id.userChooseGirl);
        userChooseBoy =findViewById(R.id.userChooseBoy);
        userChooseGameGo = findViewById(R.id.userChooseGameGo);
        userChooseGenderGo = findViewById(R.id.userChooseGenderGo);

        userChooseGameGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseExpert.this,ExpertList.class));
            }
        });


    }
}