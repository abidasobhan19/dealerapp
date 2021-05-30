package com.forbitbd.Dealer.utils;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.forbitbd.Dealer.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.auth.FirebaseAuth;

public class BaseActivity extends AppCompatActivity {




    private GoogleSignInClient client;


     MaterialToolbar toolbar;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


        client = GoogleSignIn.getClient(this, gso);


        mAuth = FirebaseAuth.getInstance();





    }

    public GoogleSignInClient getGoogleApiClient() {
        return client;
    }


    public FirebaseAuth getAuth(){
        return mAuth;
    }




    public void signOut(){
        AppPreference.getInstance(this).setDealer(null);
        client.signOut();
        mAuth.signOut();
    }

    public void setupToolbar(int id){
        toolbar = findViewById(id);
        setSupportActionBar(toolbar);

    }



}