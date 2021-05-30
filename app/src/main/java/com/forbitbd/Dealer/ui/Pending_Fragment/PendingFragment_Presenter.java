package com.forbitbd.Dealer.ui.Pending_Fragment;

import android.util.Log;

import com.forbitbd.Dealer.api.ApiClient;
import com.forbitbd.Dealer.api.ServiceGenerator;
import com.forbitbd.Dealer.models.Device;

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



                    for(Device x: deviceList){
                        mView.getpendingdevice(x);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {


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
