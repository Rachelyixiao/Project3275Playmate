package com.example.project3275playmate.MoneyRelated;

import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class TopupOptions extends AppCompatActivity {
    EditText topupAmount;
    ImageView topupPayPal,topupAlipay,topupWechat,topupBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_options);

        topupAmount = findViewById(R.id.topupAmount);
        topupAlipay = findViewById(R.id.topupAlipay);
        topupBank = findViewById(R.id.topupBank);
        topupWechat = findViewById(R.id.topupWechat);
        topupPayPal = findViewById(R.id.topupPayPal);

    }
}