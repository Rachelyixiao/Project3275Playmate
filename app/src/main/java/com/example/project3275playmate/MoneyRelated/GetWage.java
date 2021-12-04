package com.example.project3275playmate.MoneyRelated;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.Classes.Expert;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.R;

import java.sql.SQLException;

public class GetWage extends AppCompatActivity {
    TextView expertBalance;
    EditText withdrawAmount;
    Button btnGetWage;
    double balance, withdraw;
    String toast, name;
    Expert expert;
    SharedPreferences sp;
    DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_wage);
        expertBalance = findViewById(R.id.expertBalance);
        withdrawAmount = findViewById(R.id.withdrawAmount);
        btnGetWage = findViewById(R.id.btnGetwage);
        sp = getSharedPreferences("user", Context.MODE_PRIVATE);

        dao = new DAO(this);
        name = sp.getString("name", "defaultName");
        try {
            expert = dao.searchExpert(name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        balance = expert.getBalance();
        expertBalance.setText(String.valueOf(balance));
    }

    public void withdraw(View view) throws SQLException, ClassNotFoundException {
        withdraw = Double.parseDouble(withdrawAmount.getText().toString());
        if (withdraw > balance){
            Toast.makeText(this, "Not enough balance", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            toast = dao.expertWithdraw(expert, withdraw);
            expert = dao.searchExpert(name);
            balance = expert.getBalance();
            expertBalance.setText(String.valueOf(balance));
            Toast.makeText(this, toast, Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}