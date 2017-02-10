package com.romariomkk.uberserviceemulator.model.auth;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by romariomkk on 10.02.2017.
 */
public interface IDriverAuth {

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("Drivers/login")
    Call<DriverLoginResponse> executeAuth(@Body LoginCredentialsHolder holder);

}
