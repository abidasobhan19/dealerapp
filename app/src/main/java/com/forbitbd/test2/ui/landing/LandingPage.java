package com.forbitbd.test2.ui.landing;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.forbitbd.test2.utils.BaseActivity;
import com.forbitbd.test2.ui.Main.MainActivity;
import com.forbitbd.test2.R;


public class LandingPage extends BaseActivity implements View.OnClickListener , LandingContract.View {

    private Button logoutbtn ,btnentry;

    private LandingPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        mPresenter = new LandingPresenter(this);

        logoutbtn = findViewById(R.id.logout);
        btnentry = findViewById(R.id.entry);
        logoutbtn.setOnClickListener(this);
        btnentry.setOnClickListener(this);



        mPresenter.updateFirebaseToken();



    }




    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id==R.id.logout){
            mPresenter.googleclick();

        }else if(id==R.id.entry){

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public void googlelogout() {
        signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }


}