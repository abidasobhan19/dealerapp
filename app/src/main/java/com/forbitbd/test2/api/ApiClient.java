package com.forbitbd.test2.api;


import com.forbitbd.test2.models.Dealer;


import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;


public interface ApiClient {


    @POST("/dealer")
    Call<Dealer> register(@Body Dealer data);


}
