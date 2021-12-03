package com.example.project3275playmate.Homepage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.AfterPlayPages.UploadHours;
import com.example.project3275playmate.Classes.Expert;
import com.example.project3275playmate.ContactUs;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.MoneyRelated.GetWage;
import com.example.project3275playmate.R;
import com.example.project3275playmate.Settings;
import com.example.project3275playmate.UploadPages.UploadFiles;

import java.sql.SQLException;

public class ExpertMainPage extends AppCompatActivity {
    TextView ExpertName, ExpertBalance, ExpertRating;
    Button uploadProfilesLink,uploadHoursLink,getWageLink;
    ImageView homeiconExpertMain,contacticonExpertMain,settingiconExpertMain;

    SharedPreferences sp;
    DAO dao;
    Expert expert;
    double expertBalance, expertRating;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_main_page);

        ExpertBalance = findViewById(R.id.ExpertBalance);
        ExpertName = findViewById(R.id.ExpertName);
        ExpertRating = findViewById(R.id.ExpertRating);

        uploadProfilesLink = findViewById(R.id.uploadProfilesLink);
        uploadHoursLink = findViewById(R.id.uploadHoursLink);
        getWageLink = findViewById(R.id.getWagelink);

        homeiconExpertMain = findViewById(R.id.homeiconCustomerMain);
        contacticonExpertMain = findViewById(R.id.contacticonCustomerMain);
        settingiconExpertMain =findViewById(R.id.settingiconCustomerMain);

        dao = new DAO(this);
        sp = getSharedPreferences("user", Context.MODE_PRIVATE) ;
        name = sp.getString("name","defaultName");
        try {
            expert = dao.searchExpert(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ExpertName.setText(name);
        expertBalance = expert.getBalance();
        ExpertBalance.setText(String.valueOf(expertBalance));
        Toast.makeText(this, String.valueOf(expertBalance), Toast.LENGTH_SHORT).show();
        expertRating = expert.getRate();
        ExpertRating.setText(String.valueOf(expertRating));

        uploadProfilesLink.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
                startActivity(new Intent(ExpertMainPage.this,UploadFiles.class));
            }
        });

        uploadHoursLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpertMainPage.this, UploadHours.class));
            }
        });

        getWageLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpertMainPage.this, GetWage.class));
            }
        });


        homeiconExpertMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpertMainPage.this,ExpertMainPage.class));
            }
        });

        contacticonExpertMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpertMainPage.this,ContactUs.class));
            }
        });

        settingiconExpertMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpertMainPage.this, Settings.class));
            }
        });



    }
}