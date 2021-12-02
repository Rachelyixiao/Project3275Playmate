package com.example.project3275playmate.MoneyRelated;

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

public class GetWage extends AppCompatActivity {
    TextView expertBalance;
    EditText withdrawAmount;
    Button btnGetWage;
    double balance, withdraw;
    String toast;
    Expert e = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_wage);
        expertBalance = findViewById(R.id.expertBalance);
        withdrawAmount = findViewById(R.id.withdrawAmount);
        btnGetWage = findViewById(R.id.btnGetwage);


        balance = e.getBalance();
        expertBalance.setText(String.valueOf(balance));
    }
    public void register(View view){
        withdraw = Double.parseDouble(btnGetWage.toString());

        DAO dao = new DAO(this);
        try {
            toast = dao.expertWithdraw(e, withdraw);
            Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}