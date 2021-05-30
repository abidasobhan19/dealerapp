package com.forbitbd.test2.ui.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.forbitbd.test2.R;
import com.forbitbd.test2.models.Dealer;
import com.forbitbd.test2.utils.AppPreference;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
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



//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        name.setText(AppPreference.getInstance(this).getDealer().getName());
        email.setText(AppPreference.getInstance(this).getDealer().getEmail());
        phone.setText(AppPreference.getInstance(this).getDealer().getMobile());
        Picasso.with(this).load(AppPreference.getInstance(this).getDealer().getImage()).into(image);
    }
}