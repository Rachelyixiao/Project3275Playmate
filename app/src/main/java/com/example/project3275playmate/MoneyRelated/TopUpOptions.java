package com.example.project3275playmate.MoneyRelated;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class TopUpOptions extends AppCompatActivity {
    EditText topupAmount;
    ImageView topupPayPal,topupAlipay,topupWechat,topupBank;
    TextView topupInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_options);

        topupAmount = findViewById(R.id.topupAmount);
        topupAlipay = findViewById(R.id.topupAlipay);
        topupBank = findViewById(R.id.topupBank);
        topupWechat = findViewById(R.id.topupWechat);
        topupPayPal = findViewById(R.id.topupPayPal);

       //用户选择充值方式后，用来显示相关账户信息
        topupInfo =findViewById(R.id.topupInfo);




    }
}