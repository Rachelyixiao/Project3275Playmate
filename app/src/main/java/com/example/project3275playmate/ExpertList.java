package com.example.project3275playmate;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project3275playmate.R;

import java.util.ArrayList;

public class ExpertList extends AppCompatActivity {
    private static final String TAG = "ExpertList";

    //vars
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_list);
        Log.d(TAG,"onCreate: started.");

        initImageBitmaps();
    }
    private void initImageBitmaps(){
        Log.d(TAG,"initImageBitmaps: preparing bitmaps.");
        mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
        mName.add("expert 1");

        mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
        mName.add("expert 2");

        mImageUrls.add("https://i.redd.it/k98uz168eh501.jpg");
        mName.add("expert 3");
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