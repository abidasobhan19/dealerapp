package com.forbitbd.test2.ui.Main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.forbitbd.test2.R;

import com.forbitbd.test2.ui.Welcome_Fragment.WelcomeListener;
import com.forbitbd.test2.ui.Welcome_Fragment.Welcome_Fragment;
import com.forbitbd.test2.ui.login.login;
import com.forbitbd.test2.ui.landing.LandingPage;
import com.forbitbd.test2.utils.AppPreference;
import com.forbitbd.test2.utils.BaseActivity;



public class MainActivity extends BaseActivity implements MainContract.View, WelcomeListener {





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
        if(AppPreference.getInstance(this).getDealer().getIs_active()){

            Log.d("kkkkk", "StartLandingpage: "+ AppPreference.getInstance(this).getDealer().getIs_active());
            finish();
            startActivity(new Intent(getApplicationContext(), LandingPage.class));
        }else{
            Welcome_Fragment welcome_fragment = new Welcome_Fragment();
            welcome_fragment.setCancelable(false);
            welcome_fragment.show(getSupportFragmentManager(), "GHGJHGJHGHJ");
        }


    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }


}


