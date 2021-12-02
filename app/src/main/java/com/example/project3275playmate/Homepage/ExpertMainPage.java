package com.example.project3275playmate.Homepage;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.AfterPlayPages.UploadHours;
import com.example.project3275playmate.ContactUs;
import com.example.project3275playmate.R;
import com.example.project3275playmate.StartActivity;
import com.example.project3275playmate.UploadPages.UploadFiles;

public class ExpertMainPage extends AppCompatActivity {
    TextView ExpertName,ExpertBalance,ExpertRating;
    Button uploadProfilesLink,uploadHoursLink,getWageLink;
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

        getWagelink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExpertMainPage.this,"Please contact playmate representative to withdraw your wage",Toast.LENGTH_LONG).show();
                startActivity(new Intent(ExpertMainPage.this, ContactUs.class));
            }
        });



    }
}