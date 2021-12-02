package com.example.project3275playmate.Homepage;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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


    }
}