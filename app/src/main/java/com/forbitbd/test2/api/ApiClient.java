package com.forbitbd.test2.api;


import com.forbitbd.test2.models.Dealer;


import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;


public interface ApiClient {


    @POST("/dealer")
    Call<Dealer> register(@Body Dealer data);




}
