package com.forbitbd.test2.ui.landing;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.forbitbd.test2.BaseActivity;
import com.forbitbd.test2.ui.Main.MainActivity;
import com.forbitbd.test2.R;
import com.forbitbd.test2.utils.AppPreference;

public class LandingPage extends BaseActivity implements View.OnClickListener , LandingContract.View {

    private Button logoutbtn;

    private LandingPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        mPresenter = new LandingPresenter(this);

        logoutbtn = findViewById(R.id.logout);
        logoutbtn.setOnClickListener(this);



        mPresenter.updateFirebaseToken();


    }




    @Override
    public void onClick(View view) {
        AppPreference.getInstance(this).setDealer(null);
        signOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}