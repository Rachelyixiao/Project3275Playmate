package com.example.project3275playmate.MoneyRelated;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import android.widget.*;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Classes.Customer;
import com.example.project3275playmate.Classes.User;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class TopUpOptions extends AppCompatActivity {
    EditText topUpAmount, adminName;
    ImageView topUpPayPal,topUpAlipay,topUpWechat,topUpBank;
    TextView topUpInfo, getBalance;
    SharedPreferences sp;
    String CName, AName, toast, type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_options);

        adminName = findViewById(R.id.adminName);
        topUpAmount = findViewById(R.id.topupAmount);
        topUpPayPal = findViewById(R.id.topupAlipay);
        topUpAlipay = findViewById(R.id.topupBank);
        topUpWechat = findViewById(R.id.topupWechat);
        topUpBank = findViewById(R.id.topupPayPal);
        getBalance = findViewById(R.id.getBalance);

       //用户选择充值方式后，用来显示相关账户信息
        topUpInfo =findViewById(R.id.topupInfo);
        sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        CName = sp.getString("name","");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void selectionType(View view) throws SQLException, ClassNotFoundException {
        switch(view.getId()) {
            case R.id.topupAlipay:{
                    type = "AliPay";
                    cusTopUp(view);
                    break;
                }
            case R.id.topupBank:{
                    type = "Bank";
                    cusTopUp(view);
                    break;
                }
            case R.id.topupWechat:{
                    type = "Wechat";
                    cusTopUp(view);
                    break;
                }
            case R.id.topupPayPal:{
                    type = "PayPal";
                    cusTopUp(view);
                    break;
                }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void cusTopUp(View view) throws SQLException, ClassNotFoundException {
        DAO dao = new DAO(this);
        AName = adminName.getText().toString().trim();
        double Amount = Double.parseDouble(topUpAmount.getText().toString().trim());

        toast = dao.customerTopUp(CName, AName, type, Amount);
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        Customer cus = dao.searchCus(CName);

        getBalance.setText(String.valueOf(cus.getBalance()));
    }
}