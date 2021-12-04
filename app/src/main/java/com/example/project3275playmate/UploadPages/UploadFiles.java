package com.example.project3275playmate.UploadPages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Classes.Expert;
import com.example.project3275playmate.Classes.GameProfile;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.MainActivity;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class UploadFiles extends AppCompatActivity {
    SharedPreferences sp;
    DAO dao;
    String name;
    Expert expert;

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
        try {
            showProfile.setText(showGameProfile());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String showGameProfile() throws SQLException, ClassNotFoundException {
        sp = getSharedPreferences("user",MODE_PRIVATE);
        name = sp.getString("name","defaultName");
        dao = new DAO(this);
        GameProfile[] gameProfiles = dao.searchGameProfileByEName(name);
        int n=0;
        String profile = "";
        while (!(gameProfiles[n]==null)){
            profile += gameProfiles[n].getGName() + " description: \n" + gameProfiles[n].getDescription() + "\n\n";
            n++;
        }
        return profile;
    }
}