package com.example.project3275playmate.Homepage;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.AfterPlayPages.ReviewExpert;
import com.example.project3275playmate.ChooseExpert;
import com.example.project3275playmate.Classes.TopUp;
import com.example.project3275playmate.R;

public class UserMainPage extends AppCompatActivity {
    Button btnChooseExpert,btnTopup,btnReviewExpert,btnViewBalanceUse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_page);

        btnChooseExpert = findViewById(R.id.btnChooseExpert);
        btnTopup = findViewById(R.id.btnTopup);
        btnReviewExpert = findViewById(R.id.btnReviewExpert);
        btnViewBalanceUse = findViewById(R.id.btnViewBalanceUse);

        btnChooseExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMainPage.this, ChooseExpert.class));
            }
        });

        btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMainPage.this, TopUp.class));
            }
        });

        btnReviewExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMainPage.this, ReviewExpert.class));
            }
        });


    }
}