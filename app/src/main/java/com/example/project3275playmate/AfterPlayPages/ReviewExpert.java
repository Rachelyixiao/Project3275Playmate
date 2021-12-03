package com.example.project3275playmate.AfterPlayPages;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Classes.Expert;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class ReviewExpert extends AppCompatActivity {
    EditText EName,comments;
    RadioButton review5,review4,review3,review2,review1;
    RadioGroup Reviews;
    int rate;
    Button submitReviews;
    String toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_expert);
        EName = findViewById(R.id.EName);
        review1 = findViewById(R.id.review1);
        review2 = findViewById(R.id.review2);
        review3 = findViewById(R.id.review3);
        review4 = findViewById(R.id.review4);
        review5 = findViewById(R.id.review5);
        comments = findViewById(R.id.comments);
        submitReviews = findViewById(R.id.submitReviews);
    }

    public void selectionRate(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.review1:
                if (checked){
                    rate = 1;
                    break;
                }
            case R.id.review2:
                if (checked){
                    rate = 2;
                    break;
                }
            case R.id.review3:
                if (checked){
                    rate = 3;
                    break;
                }
            case R.id.review4:
                if (checked){
                    rate = 4;
                    break;
                }
            case R.id.review5:
                if (checked){
                    rate = 5;
                    break;
                }
        }
    }

    public void rateExpert(View view) throws SQLException, ClassNotFoundException {
        DAO dao = new DAO(this);
        String name = EName.getText().toString().trim();
        String comment = comments.getText().toString().trim();
        Expert e = null;
        if (name.equals("")){
            Toast.makeText(this, "Please enter your playmate's name.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (rate==0){
            Toast.makeText(this, "Please rate your playmate.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (dao.searchExpert(name) == null){
            Toast.makeText(this, "The name you entered does not exist", Toast.LENGTH_SHORT).show();
            return;
        }
        e = dao.searchExpert(name);
        toast = dao.expertRating(e, rate);
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();

    }
}