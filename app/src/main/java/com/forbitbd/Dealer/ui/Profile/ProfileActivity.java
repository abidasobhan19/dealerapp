package com.forbitbd.Dealer.ui.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.forbitbd.Dealer.R;
import com.forbitbd.Dealer.utils.AppPreference;
import com.google.android.material.textfield.TextInputEditText;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private TextInputEditText name,email, org, phone, address;
    private CircularImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.username);
        email = findViewById(R.id.useremail);
        org = findViewById(R.id.org_name);
        phone = findViewById(R.id.userphone);
        address = findViewById(R.id.useraddress);
        image = findViewById(R.id.userphoto);




        name.setText(AppPreference.getInstance(this).getDealer().getName());
        email.setText(AppPreference.getInstance(this).getDealer().getEmail());
        phone.setText(AppPreference.getInstance(this).getDealer().getMobile());
        Picasso.with(this).load(AppPreference.getInstance(this).getDealer().getImage()).into(image);
    }
}