package com.example.project3275playmate.UploadPages;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Pojo.GameProfile;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class AddProfiles extends AppCompatActivity {
    Spinner addGameListProfile;
    TextView getSkills;
    Button submitGameProfile;
    SharedPreferences sp;
    String toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profiles);
        addGameListProfile = findViewById(R.id.addGameListProfile);
        getSkills = findViewById(R.id.getSkills);
        submitGameProfile = findViewById(R.id.btnSubmitProfile);

        sp = getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    public void addGameProfile(View view) throws SQLException, ClassNotFoundException {
        DAO dao = new DAO(this);
        String GName = addGameListProfile.getSelectedItem().toString();
        String EName = sp.getString("name", "defaultName");
        String description = getSkills.getText().toString();
        GameProfile gp = dao.searchGameProfile(GName);
        if (!gp.equals(null)){
            Toast.makeText(this, "The Game Profile already exists, please select another one.", Toast.LENGTH_SHORT).show();;
            return;
        }
        try {
            toast = dao.addingProfile(GName, EName, description);
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(this, "The Game Profile already exists, please select another one.", Toast.LENGTH_SHORT).show();;
        } catch (ClassNotFoundException e) {
            Toast.makeText(this, "The Game Profile already exists, please select another one.", Toast.LENGTH_SHORT).show();;
        }
        startActivity(new Intent(AddProfiles.this, UploadFiles.class));
    }
}