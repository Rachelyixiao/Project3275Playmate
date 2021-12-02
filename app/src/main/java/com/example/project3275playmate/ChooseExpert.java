package com.example.project3275playmate;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class ChooseExpert extends AppCompatActivity {
    Spinner userChooseGameList;
    RadioGroup userChooseGender;
    RadioButton userChooseGirl,userChooseBoy;
    Button userChooseGameGo,userChooseGenderGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_expert);

        //两种选择方式，选择游戏，显示该游戏所有玩家信息；选择性别，选择该性别所有的玩家
        userChooseGameList = findViewById(R.id.userChooseGameList);
        userChooseGender = findViewById(R.id.userChooseGender);
        userChooseGirl = findViewById(R.id.userChooseGirl);
        userChooseBoy =findViewById(R.id.userChooseBoy);
        userChooseGameGo = findViewById(R.id.userChooseGameGo);
        userChooseGenderGo = findViewById(R.id.userChooseGenderGo);



    }
}