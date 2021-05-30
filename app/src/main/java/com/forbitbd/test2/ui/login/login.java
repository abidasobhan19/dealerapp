package com.forbitbd.test2.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.forbitbd.test2.ui.Main.MainActivity;
import com.forbitbd.test2.utils.BaseActivity;
import com.forbitbd.test2.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;

public class login extends BaseActivity implements View.OnClickListener, LoginContract.View {
    private static final String TAG = "MainActivity";
    private static final int RC_SIGN_IN = 9001;
    private LoginPresenter mPresenter;

    private SignInButton signInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mPresenter = new LoginPresenter(this);

        signInButton = findViewById(R.id.google_sign_in);

        signInButton.setOnClickListener(this);



    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case RC_SIGN_IN:
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                mPresenter.startAutentication(result);
                break;
        }


    }




    @Override
    public void googleSignIn() {
        Intent signInIntent = getGoogleApiClient().getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }



    @Override
    public void startMainActivity() {
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onClick(View view) {
        mPresenter.google_click();
    }
}