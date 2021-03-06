package com.example.project3275playmate.Homepage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.AfterPlayPages.ReviewExpert;
import com.example.project3275playmate.ChooseExpert;
import com.example.project3275playmate.ContactUs;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.MoneyRelated.TopUpOptions;
import com.example.project3275playmate.R;
import com.example.project3275playmate.Settings;

import java.sql.SQLException;

public class CustomerMainPage extends AppCompatActivity {
    Button btnChooseExpert, btnTopUp, btnReviewExpert, btnViewBalanceUse;
    ImageView homeIconCustomerMain, contactIconCustomerMain, settingIconCustomerMain;

    TextView username, balance;
    SharedPreferences sp;
    String name;
    double Balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main_page);
        sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        btnChooseExpert = findViewById(R.id.btnChooseExpert);
        btnTopUp = findViewById(R.id.btnTopup);
        btnReviewExpert = findViewById(R.id.btnReviewExpert);
        username = findViewById(R.id.Username);
        balance = findViewById(R.id.Balance);
        homeIconCustomerMain = findViewById(R.id.homeiconCustomerMain);
        contactIconCustomerMain = findViewById(R.id.contacticonCustomerMain);
        settingIconCustomerMain = findViewById(R.id.settingiconCustomerMain);

        DAO dao = new DAO(this);
        name = sp.getString("name","");
        username.setText(name);
        try {
            Balance = dao.searchCus(name).getBalance();
            balance.setText(Double.toString(Balance));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        btnChooseExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerMainPage.this, ChooseExpert.class));
            }
        });

        btnTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerMainPage.this, TopUpOptions.class));
            }
        });

        btnReviewExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerMainPage.this, ReviewExpert.class));
            }
        });

        homeIconCustomerMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerMainPage.this, CustomerMainPage.class));
            }
        });

        contactIconCustomerMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerMainPage.this, ContactUs.class));
            }
        });

        settingIconCustomerMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerMainPage.this, Settings.class));
            }
        });


    }
}