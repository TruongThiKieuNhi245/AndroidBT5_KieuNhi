package com.example.androidbt5_kieunhi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView ivSettings, ivBack, ivProfileImage;
    private TextView tvProfileName, tvFollowers, tvFollowing;
    private TextView tvEmail, tvPhone, tvSkype, tvWebsite;
    private TextView tvShowAccountInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        ivSettings = findViewById(R.id.ivSettings);
        ivBack = findViewById(R.id.ivBack);
        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvProfileName = findViewById(R.id.tvProfileName);
        tvFollowers = findViewById(R.id.tvFollowers);
        tvFollowing = findViewById(R.id.tvFollowing);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSkype = findViewById(R.id.tvSkype);
        tvWebsite = findViewById(R.id.tvWebsite);
        tvShowAccountInfo = findViewById(R.id.tvShowAccountInfo);

        // Get data from Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String skype = intent.getStringExtra("skype");
        String website = intent.getStringExtra("website");

        // Set profile data
        tvProfileName.setText(username != null ? username : "Profile Name");
        tvEmail.setText("Email: " + (email != null ? email : "N/A"));
        tvPhone.setText("Phone: " + (phone != null ? phone : "N/A"));
        tvSkype.setText("Skype: " + (skype != null ? skype : "N/A"));
        tvWebsite.setText("Web: " + (website != null ? website : "N/A"));

        // Settings button - return to Login
        ivSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Return to MainActivity (Login screen)
            }
        });

        // Back button
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Show account info button
        tvShowAccountInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountInfo = "Thông tin tài khoản:\n" +
                        "Username: " + username + "\n" +
                        "Email: " + email + "\n" +
                        "Phone: " + phone + "\n" +
                        "Skype: " + skype + "\n" +
                        "Website: " + website;
                Toast.makeText(ProfileActivity.this, accountInfo, Toast.LENGTH_LONG).show();
            }
        });
    }
}
