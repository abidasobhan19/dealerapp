package com.forbitbd.Dealer.api;


import com.forbitbd.Dealer.models.Dealer;
import com.forbitbd.Dealer.models.Device;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface ApiClient {


    @POST("/dealer")
    Call<Dealer> register(@Body Dealer data);

    @PUT("/dealer/{email}")
    Call<Dealer> updateDealer(@Path("email") String email,@Body Dealer dealer);

    @POST("/connection")
    Call<Device> registerDevice(@Body Device data);

    @GET("/connection/{id}/connected")
    Call<List<Device>> getConnectedDevice(@Path("id") String id);

    @GET("/connection/{id}/pending")
    Call<List<Device>> getPendingDevice(@Path("id") String id);

}
