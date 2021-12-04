package com.example.project3275playmate.AfterPlayPages;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project3275playmate.Classes.Expert;
import com.example.project3275playmate.DAO.DAO;
import com.example.project3275playmate.Homepage.ExpertMainPage;
import com.example.project3275playmate.R;
import com.example.project3275playmate.RegisterLogin.ExpertRegisterPage;
import com.example.project3275playmate.databinding.ActivityUploadHoursBinding;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

public class UploadHours extends AppCompatActivity {
    DatePickerDialog datePickerDialog;

    EditText expertName, customerName, adminName, playdate, playHours;
    Button submitHours;
    String toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.project3275playmate.databinding.ActivityUploadHoursBinding binding = ActivityUploadHoursBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        expertName = findViewById(R.id.expertName);
        customerName = findViewById(R.id.customerName);
        adminName = findViewById(R.id.adminName);
        playdate = findViewById(R.id.playdate);
        playHours = findViewById(R.id.playHours);
        submitHours = findViewById(R.id.submitHours);

    }

    public void submitTransactions(View view) throws SQLException, ClassNotFoundException {
        DAO dao = new DAO(this);

        String AName = adminName.getText().toString().trim();
        String CName = customerName.getText().toString().trim();
        String EName = expertName.getText().toString().trim();
        String date = playdate.getText().toString().trim();
        String hoursString = playHours.getText().toString().trim();
        double hours;
        if (AName.equals("")||CName.equals("")||EName.equals("")||date.equals("")||hoursString.equals("")){
            Toast.makeText(this, "Please enter all the info", Toast.LENGTH_SHORT).show();
            return;
        }

        Expert expert;
        expert = dao.searchExpert(EName);
        double wage = expert.getWage();
        double amount;
        try {
            hours = Double.parseDouble(playHours.getText().toString().trim());
            amount = wage * hours;
        }
        catch (Exception e){
            Toast.makeText(this, "Please enter the correct format of hours", Toast.LENGTH_SHORT).show();
            return;
        }
        //transactionsMain(String CusName, String expertName, String date, String adminName, double hours, double amount)
        toast = dao.transactionsMain(CName, EName, date, AName, hours, amount);
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        if (!toast.contains("Transaction successful!")){
            return;
        }
        startActivity(new Intent(UploadHours.this, ExpertMainPage.class));
    }
}