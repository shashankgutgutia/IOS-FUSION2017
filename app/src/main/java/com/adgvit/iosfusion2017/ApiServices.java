package com.adgvit.iosfusion2017;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("/refreshments/new")
    @FormUrlEncoded
    Call<RefreshmentPost> postrefrsh(@Body RefreshmentPost refreshmentPost);
}
