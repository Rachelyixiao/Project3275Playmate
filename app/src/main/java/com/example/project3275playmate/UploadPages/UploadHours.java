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






        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_contact, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_upload_hours);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}