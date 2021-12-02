package com.example.project3275playmate.AfterPlayPages;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class ReviewExpert extends AppCompatActivity {
    EditText expertID,comments;
    RadioButton review5,review4,review3,review2,review1;
    RadioGroup Reviews;
    Button submitReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_expert);
        expertID = findViewById(R.id.expertID);
        review1 = findViewById(R.id.review1);
        review2 = findViewById(R.id.review2);
        review3 = findViewById(R.id.review3);
        review4 = findViewById(R.id.review4);
        review5 = findViewById(R.id.review5);
        comments = findViewById(R.id.comments);
        submitReviews = findViewById(R.id.submitReviews);


    }
}