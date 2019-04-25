package com.retrofitexample.retrofit;

import com.retrofitexample.model.UserProfile;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    /*@Headers({
            "GRUPAPP: 123456",
            "Content-Type: application/json"
    })*/
    @POST("api/getprofile")
    Call<UserProfile> getUserProfile(@Query("user_id") String user_id,
                                     @Query("device_token") String device_token,
                                     @Query("device_id") String device_id,
                                     @Query("device_type") String device_type);
}