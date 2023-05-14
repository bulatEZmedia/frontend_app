package com.example.frontend_app;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @POST("register")
    Call<ResponseBody> register(
            @Query("username") String username,
            @Query("name") String name,
            @Query("surname") String surname,
            @Query("email") String email,
            @Query("password") String password
    );

    @POST("authorization")
    Call<ResponseBody> authorization(
            @Query("email") String email,
            @Query("password") String password
    );


}

