package com.forbitbd.Dealer.ui.Main;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainPresenter implements MainContract.Presenter {

        private MainContract.View mView;
        private FirebaseUser mCurrentUser;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void checkdealer() {
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (mCurrentUser ==null){

            mView.StartloginActivity();

        }else {
            mView.StartLandingpage();
        }
    }







}
