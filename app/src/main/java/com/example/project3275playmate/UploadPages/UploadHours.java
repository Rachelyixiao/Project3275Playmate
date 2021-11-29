package com.example.project3275playmate.UploadPages;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.project3275playmate.R;
import com.example.project3275playmate.databinding.ActivityUploadHoursBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class UploadHours extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    private ActivityUploadHoursBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUploadHoursBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText playdate = findViewById(R.id.txtplaydate);

        //Choose the date of play
        playdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar ca = Calendar.getInstance();
                int year = ca.get(Calendar.YEAR);
                int month = ca.get(Calendar.MONTH);
                int day = ca.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(UploadHours.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                playdate.setText(year + "/"
                                        + (monthOfYear + 1) + "/" + dayOfMonth);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });







    }

}