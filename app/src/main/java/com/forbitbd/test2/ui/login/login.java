package com.forbitbd.test2.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.forbitbd.test2.BaseActivity;
import com.forbitbd.test2.ui.landing.LandingPage;
import com.forbitbd.test2.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;

public class login extends BaseActivity implements View.OnClickListener, LoginContract.View{
    private static final String TAG = "MainActivity";
    private static final int RC_SIGN_IN = 9001;
    private LoginPresenter mpresenter;

    private SignInButton signInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mpresenter = new LoginPresenter(this);

        signInButton = findViewById(R.id.google_sign_in);

        signInButton.setOnClickListener(this);



    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == RC_SIGN_IN) {
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            try {
//                // Google Sign In was successful, authenticate with Firebase
//                GoogleSignInAccount account = task.getResult(ApiException.class);
//                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
//                firebaseAuthWithGoogle(account.getIdToken());
//            } catch (ApiException e) {
//                // Google Sign In failed, update UI appropriately
//                Log.d(TAG, "Google sign in failed", e);
//            }
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case RC_SIGN_IN:
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                mpresenter.startAutentication(result);
                break;
        }


    }




    @Override
    public void googleSignIn() {
        Intent signInIntent = getGoogleApiClient().getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    @Override
    public void onClick(View view) {
        googleSignIn();
    }

    @Override
    public void startMainActivity() {
        finish();
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }
}