package com.example.project3275playmate.UploadPages;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class AddProfiles extends AppCompatActivity {
    Spinner addGamelistProfile;
    TextView getSkills;
    Button submitGameProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profiles);


        addGamelistProfile = findViewById(R.id.addGamelistProfile);
        getSkills = findViewById(R.id.getSkills);
        submitGameProfile = findViewById(R.id.btnSubmitProfile);




    }
}