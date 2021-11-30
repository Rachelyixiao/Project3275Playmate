package com.example.project3275playmate.RegisterLogin;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.R;

public class RegisterPage extends AppCompatActivity {
    TextView getName, getEmail, getPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        getName = findViewById(R.id.getUserName);
        getEmail = findViewById(R.id.getEmail);
        getPassword = findViewById(R.id.getPassword);
    }

    public void selection( View view) {
        int choice = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.customer:
                if (checked){
                    choice =  0;
                    Toast.makeText(this, "You selected to be a customer",Toast.LENGTH_LONG).show();
                }
            case R.id.expert:
                if (checked){
                    choice =  1;
                    Toast.makeText(this, "You selected to be an expert",Toast.LENGTH_LONG).show();
                }
        }
    }
}