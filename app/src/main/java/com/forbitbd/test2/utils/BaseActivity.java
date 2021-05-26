package com.forbitbd.test2.utils;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.forbitbd.test2.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BaseActivity extends AppCompatActivity {




    private GoogleSignInClient client;



    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;


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

}