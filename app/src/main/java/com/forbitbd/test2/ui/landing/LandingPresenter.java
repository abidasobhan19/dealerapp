package com.forbitbd.test2.ui.landing;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.forbitbd.test2.api.ApiClient;
import com.forbitbd.test2.api.ServiceGenerator;
import com.forbitbd.test2.models.Dealer;
import com.forbitbd.test2.utils.AppPreference;
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
                            Log.w("hhhh", "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        Dealer dealer = AppPreference.getInstance((Context) mView).getDealer();
                        dealer.setFcm_token(token);

                        ApiClient client = ServiceGenerator.createService(ApiClient.class);
                        client.updateDealer(dealer.getEmail(),dealer)
                                .enqueue(new Callback<Dealer>() {
                                    @Override
                                    public void onResponse(Call<Dealer> call, Response<Dealer> response) {
                                        if(response.isSuccessful()){
                                            Log.d("HHHHH",response.body().getFcm_token());
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Dealer> call, Throwable t) {

                                    }
                                });


//                        Log.d("HHHHH", AppPreference.getInstance((Context) mView).getDealer().getEmail()+"");
//




                    }
                });
    }
}