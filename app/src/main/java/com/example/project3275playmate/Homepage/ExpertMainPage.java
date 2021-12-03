package com.example.project3275playmate.Homepage;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.AfterPlayPages.UploadHours;
import com.example.project3275playmate.ContactUs;
import com.example.project3275playmate.MoneyRelated.GetWage;
import com.example.project3275playmate.R;
import com.example.project3275playmate.Settings;
import com.example.project3275playmate.UploadPages.UploadFiles;

public class ExpertMainPage extends AppCompatActivity {
    TextView ExpertName,ExpertBalance,ExpertRating;
    Button uploadProfilesLink,uploadHoursLink,getWageLink;
    ImageView homeiconExpertMain,contacticonExpertMain,settingiconExpertMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_main_page);

        ExpertBalance = findViewById(R.id.ExpertBalance);
        ExpertName  =findViewById(R.id.ExpertName);
        ExpertRating = findViewById(R.id.ExpertRating);

        uploadProfilesLink = findViewById(R.id.uploadProfilesLink);
        uploadHoursLink = findViewById(R.id.uploadHoursLink);
        getWageLink = findViewById(R.id.getWagelink);

        homeiconExpertMain=findViewById(R.id.homeiconCustomerMain);
        contacticonExpertMain = findViewById(R.id.contacticonCustomerMain);
        settingiconExpertMain =findViewById(R.id.settingiconCustomerMain);

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