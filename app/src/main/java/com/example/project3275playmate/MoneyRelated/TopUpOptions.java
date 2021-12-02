package com.example.project3275playmate.MoneyRelated;

import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class TopUpOptions extends AppCompatActivity {
    EditText topUpAmount;
    ImageView topUpPayPal,topUpAlipay,topUpWechat,topUpBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_options);

        topUpAmount = findViewById(R.id.topupAmount);
        topUpAlipay = findViewById(R.id.topupAlipay);
        topUpBank = findViewById(R.id.topupBank);
        topUpWechat = findViewById(R.id.topupWechat);
        topUpPayPal = findViewById(R.id.topupPayPal);

    }
}