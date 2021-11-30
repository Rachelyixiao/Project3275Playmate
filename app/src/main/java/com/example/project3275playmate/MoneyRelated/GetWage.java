package com.example.project3275playmate.MoneyRelated;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class GetWage extends AppCompatActivity {
    TextView expertBalance;
    EditText withdrawAmount;
    Button btnGetwage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_wage);
        expertBalance = findViewById(R.id.expertBalance);
        withdrawAmount = findViewById(R.id.withdrawAmount);
        btnGetwage = findViewById(R.id.btnGetwage);

    }
}