package com.forbitbd.Dealer.ui.landing;

import android.content.Context;

import androidx.annotation.NonNull;

import com.forbitbd.Dealer.api.ApiClient;
import com.forbitbd.Dealer.api.ServiceGenerator;
import com.forbitbd.Dealer.models.Dealer;
import com.forbitbd.Dealer.utils.AppPreference;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LandingPresenter implements LandingContract.Presenter {

    private LandingContract.View mView;

    public LandingPresenter(LandingContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void updateFirebaseToken() {

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {

                            return;
                        }


                        String token = task.getResult();

                        Dealer dealer = AppPreference.getInstance((Context) mView).getDealer();
                        dealer.setFcm_token(token);

                        ApiClient client = ServiceGenerator.createService(ApiClient.class);
                        client.updateDealer(dealer.getEmail(),dealer)
                                .enqueue(new Callback<Dealer>() {
                                    @Override
                                    public void onResponse(Call<Dealer> call, Response<Dealer> response) {
                                        if(response.isSuccessful()){

                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Dealer> call, Throwable t) {

                                    }
                                });

                    }
                });
    }

    @Override
    public void googleclick() {
        mView.googlelogout();
    }


}
