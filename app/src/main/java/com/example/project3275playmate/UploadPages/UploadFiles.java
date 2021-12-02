package com.example.project3275playmate.UploadPages;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.MainActivity;
import com.example.project3275playmate.R;

public class UploadFiles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_files);

        Button btnAddSkill = findViewById(R.id.addSkills);

        Button btnFinishEdit = findViewById(R.id.finishEdit);
        TextView showProfile = findViewById(R.id.showProfile);

        btnAddSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UploadFiles.this, AddProfiles.class));
            }
        });

        btnFinishEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UploadFiles.this, MainActivity.class));
            }
        });
    }
}