package com.forbitbd.test2;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseUser;

public class LandingPage extends BaseActivity implements View.OnClickListener {

    private Button logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        logoutbtn = findViewById(R.id.logout);
        logoutbtn.setOnClickListener(this);

        FirebaseUser currentUser = getAuth().getCurrentUser();
        if (currentUser !=null) {


        }else{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));


        }
    }




    @Override
    public void onClick(View view) {
        signOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}