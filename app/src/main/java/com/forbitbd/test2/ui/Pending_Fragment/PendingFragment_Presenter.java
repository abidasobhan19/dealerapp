package com.forbitbd.test2.ui.Pending_Fragment;

import android.util.Log;

import com.forbitbd.test2.api.ApiClient;
import com.forbitbd.test2.api.ServiceGenerator;
import com.forbitbd.test2.models.Dealer;
import com.forbitbd.test2.models.Device;
import com.forbitbd.test2.utils.AppPreference;
import com.google.android.gms.common.api.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendingFragment_Presenter implements PandingFragment_Contract.Presenter {


    private PandingFragment_Contract.View mView;

    public PendingFragment_Presenter(PandingFragment_Contract.View mView) {
        this.mView = mView;
    }



    @Override
    public void getPendingDevice(String _id) {

        ApiClient client = ServiceGenerator.createService(ApiClient.class);
        client.getPendingDevice(_id).enqueue(new Callback<List<Device>>() {
            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {

                if(response.isSuccessful()){
                    List<Device> deviceList = response.body();

                    Log.d("HHHHHH","YES"+deviceList.size());

                    for(Device x: deviceList){
                        mView.getpendingdevice(x);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {
                Log.d("HHHHHH","NO"+t.getMessage());

            }
        });


//    @Override
//    public void getupdatedevice() {
//
//
//
//        ApiClient client = ServiceGenerator.createService(ApiClient.class);
//        client.getPendingDevice().enqueue(new Callback<List<Device>>() {
//            @Override
//            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
//                if(response.isSuccessful()){
//                    mView.updateDevice(response.body());
//                    Log.d("kkkkkkk", "onResponse: "+response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Device>> call, Throwable t) {
//
//            }
//        });






    }
}
