package com.example.project3275playmate;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.util.ArrayList;

public class ExpertList extends AppCompatActivity {
    private static final String TAG = "ExpertList";
String Game,Gender;
    //vars
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_list);
        Log.d(TAG,"onCreate: started.");
        SharedPreferences sp = getSharedPreferences("Choice",MODE_PRIVATE);
         Game = sp.getString("Game","");
         Gender = sp.getString("Choice","");
        String btn = sp.getString("btn","");

        if (btn.equals("Game")){
            initImageBitmaps();
        }
        else if(btn.equals("Gender")){
            initImageBitmaps2();
        }
    }

    private void initImageBitmaps(){
//        Log.d(TAG,"initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("app/src/main/res/drawable/profile.png");
        mName.add(Game);
        mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
        mName.add(Gender);
//    while (c.moveToNext()){
//        mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
//        mName.add(c.getString());
//    }

        initRecyclerView();
    }

    private void initImageBitmaps2(){
        DAO dao = new DAO(this);

        Cursor c = dao.viewExpertDataByGender(Gender);
        while (c.moveToNext()){
            String info = " PlayMate's Name: " + c.getString(0) + "\n PlayMate's Rating: " + c.getString(2);
            mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
            mName.add(info);
        }
        initRecyclerView();
    }

    private  void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.rec);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this,mName,mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}