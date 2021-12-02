package com.example.project3275playmate;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpertList extends AppCompatActivity {


    String[] expertName = {"Tom","Merry","Santa"};
    Double[] expertRating = {1.2,3.6,2.3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_list);



        List<HashMap<String,String>> expertList = new ArrayList<>();

        for(int i=0;i<3;i++){
            HashMap<String,String> hashMapExpert = new HashMap<>();
            hashMapExpert.put("name",expertName[i]);
            hashMapExpert.put("rating",Double.toString(expertRating[i]));
        }

        String[] from = {"name","rating"};
        int[] to = {R.id.expert_name,R.id.expert_rating};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(),expertList,R.layout.expert_list_item,from,to);
        ListView expertListView= findViewById(R.id.expertListView);;
        expertListView.setAdapter(adapter);


        expertListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch ((position)){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http:www.google.com")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http:www.sfu.com")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http:www.douglas.com")));
                        break;
                }
            }
        });

    }
}