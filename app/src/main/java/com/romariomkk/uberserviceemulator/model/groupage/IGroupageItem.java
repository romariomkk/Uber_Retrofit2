package com.romariomkk.uberserviceemulator.model.groupage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by romariomkk on 10.02.2017.
 */
public interface IGroupageItem {

    @Headers("Accept: application/json")
    @GET("Drivers/{id}/groupages")
    Call<List<Groupage>> getGroupages(@Path("id") String path, @Query("access_token") String token);

}
