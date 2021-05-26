package com.forbitbd.test2.ui.landing;

import com.forbitbd.test2.models.Dealer;

public interface LandingContract {

    interface Presenter{
       void updateFirebaseToken();
       void googleclick();

    }

    interface View{


        void googlelogout();

    }
}
