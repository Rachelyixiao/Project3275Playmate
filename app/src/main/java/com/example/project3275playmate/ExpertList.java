package com.example.project3275playmate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project3275playmate.Classes.GameProfile;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExpertList extends AppCompatActivity {
    private static final String TAG = "ExpertList";
    String game, gender;
    ImageView contacticon;

    //vars
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_list);
        Log.d(TAG,"onCreate: started.");
        SharedPreferences sp = getSharedPreferences("Choice",MODE_PRIVATE);
        game = sp.getString("Game","");
        gender = sp.getString("Choice","");
        String btn = sp.getString("btn","");
      //  contacticon = findViewById(R.id.contacticon);

        if (btn.equals("Game")){
            try {
                initImageBitmaps();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if(btn.equals("Gender")){
            initImageBitmaps2();
        }
/*
        contacticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExpertList.this, ContactUs.class));
            }
        });
*/
    }

    private void initImageBitmaps() throws SQLException, ClassNotFoundException {
        DAO dao = new DAO(this);
        GameProfile[] gameProfiles = dao.searchGameProfileByGName(game);
        int n=0;
        while (!(gameProfiles[n]==null)){
            String profile =" PlayMate's Name: " + gameProfiles[n].getEName() + "\n" + " Game: "
                    + gameProfiles[n].getGName() + "\n Description: " + gameProfiles[n].getDescription() + "\n\n";
            n++;
            mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
            mName.add(profile);
        }
        initRecyclerView();
    }

    private void initImageBitmaps2(){
        DAO dao = new DAO(this);
        Cursor c = dao.viewExpertDataByGender(gender);
        while (c.moveToNext()){
            String info = " PlayMate's Name: " + c.getString(0) + "\n PlayMate's Rating: " + c.getString(2);
            mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
            mName.add(info);
        }
        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.rec);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, mName, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}