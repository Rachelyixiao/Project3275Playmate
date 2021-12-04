package com.example.project3275playmate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.Homepage.CustomerMainPage;
import com.example.project3275playmate.R;
import com.example.project3275playmate.RegisterLogin.LoginPage;

public class ChooseExpert extends AppCompatActivity {
    Spinner userChooseGameList;
    RadioGroup userChooseGender;
    RadioButton userChooseGirl,userChooseBoy;
    Button userChooseGameGo,userChooseGenderGo;
    DAO dao ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_expert);
        SharedPreferences Choice = getSharedPreferences("Choice",MODE_PRIVATE);
        dao = new DAO(this);
        //两种选择方式，选择游戏，显示该游戏所有玩家信息；选择性别，选择该性别所有的玩家
        userChooseGameList = findViewById(R.id.userChooseGameList);
        userChooseGender = findViewById(R.id.userChooseGender);
        userChooseGirl = findViewById(R.id.userChooseGirl);
        userChooseBoy =findViewById(R.id.userChooseBoy);
        userChooseGameGo = findViewById(R.id.userChooseGameGo);
        userChooseGenderGo = findViewById(R.id.userChooseGenderGo);
        SharedPreferences.Editor editor = Choice.edit();
        userChooseGameGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  currencyChoice = userChooseGameList.getSelectedItem().toString();

                editor.putString("Game", currencyChoice);
                editor.putString("btn", "Game");
                editor.commit();

                startActivity(new Intent(ChooseExpert.this, ExpertList.class));
            }
        });

        userChooseGenderGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userChooseGirl.isChecked()){

                    editor.putString("Choice", "girl");
                    editor.putString("btn", "Gender");
                    editor.commit();//选的是女生，把关键词Girl保存并进入下一页
                    startActivity(new Intent(ChooseExpert.this, ExpertList.class));


                }
                else if (userChooseBoy.isChecked()){
                    editor.putString("Choice", "boy");
                    editor.putString("btn", "Gender");
                    editor.commit();//选的是男生，把关键词Boy保存并进入下一页
                    startActivity(new Intent(ChooseExpert.this, ExpertList.class));
                }
                else{
                    //未选性别，错误提示
                    Toast.makeText(ChooseExpert.this,"Please select a Gender",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}