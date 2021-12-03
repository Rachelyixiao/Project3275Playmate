package com.example.project3275playmate;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.util.ArrayList;

public class ExpertList extends AppCompatActivity {
    private static final String TAG = "ExpertList";
    SharedPreferences sp;
    //vars
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_list);
        Log.d(TAG,"onCreate: started.");
        String btn = sp.getString("btn","");

        if (btn =="Game"){
            initImageBitmaps();
        }
        else if(btn == "Gender"){
            initImageBitmaps2();
        }
        else{

        }




    }
    private void initImageBitmaps(){
        sp = getSharedPreferences("", Context.MODE_PRIVATE);
        DAO dao = new DAO(this);
        String Game = sp.getString("Game","");
        Cursor c = dao.viewExpertDataByGender(Game);
        Log.d(TAG,"initImageBitmaps: preparing bitmaps.");


//    while (c.moveToNext()){
//        mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
//        mName.add(c.getString());
//    }

        initRecyclerView();

    }
    private void initImageBitmaps2(){
        sp = getSharedPreferences("", Context.MODE_PRIVATE);
        DAO dao = new DAO(this);
        String Gender = sp.getString("Choice","");
        Cursor c = dao.viewExpertDataByGender(Gender);

        while (c.moveToNext()){
            mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
            mName.add(c.getString(1));
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