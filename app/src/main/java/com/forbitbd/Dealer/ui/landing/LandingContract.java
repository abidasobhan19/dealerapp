package com.forbitbd.Dealer.ui.landing;

public interface LandingContract {

    interface Presenter{
       void updateFirebaseToken();
       void googleclick();

    }

    interface View{


        void googlelogout();

    }
}
