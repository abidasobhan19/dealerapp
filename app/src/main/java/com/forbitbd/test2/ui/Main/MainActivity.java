package com.forbitbd.test2.ui.Main;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import com.forbitbd.test2.R;
import com.forbitbd.test2.ui.login.login;

import com.forbitbd.test2.ui.landing.LandingPage;


public class MainActivity extends AppCompatActivity implements MainContract.View {

private MainPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mPresenter = new MainPresenter(this);

        mPresenter.checkdealer();



    }



    public void StartloginActivity(){
        finish();
        startActivity(new Intent(getApplicationContext(), login.class));
    }

    public void StartLandingpage(){
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
    }


