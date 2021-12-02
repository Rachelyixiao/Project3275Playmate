package com.example.project3275playmate;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.project3275playmate.RegisterLogin.LoginPage;

public class ContactUs extends AppCompatActivity {
    ImageView homeIconContact,contactIconContact,settingIconContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        homeIconContact = findViewById(R.id.homeiconContact);
        contactIconContact = findViewById(R.id.contacticonContact);
        settingIconContact = findViewById(R.id.settingiconContact);;

        homeIconContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this,LoginPage.class));
            }
        });

        contactIconContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this,ContactUs.class));
            }
        });

        settingIconContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this,Settings.class));
            }
        });

    }


}