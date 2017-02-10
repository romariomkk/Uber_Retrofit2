package com.romariomkk.uberserviceemulator.service;

import android.util.Log;

import com.romariomkk.uberserviceemulator.model.auth.DriverLoginResponse;
import com.romariomkk.uberserviceemulator.model.auth.IDriverAuth;
import com.romariomkk.uberserviceemulator.model.auth.LoginCredentialsHolder;
import com.romariomkk.uberserviceemulator.model.groupage.Groupage;
import com.romariomkk.uberserviceemulator.model.groupage.IGroupageItem;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by romariomkk on 10.02.2017.
 */
public class RetrofitManager {

    private static final String TAG = RetrofitManager.class.getSimpleName();


    private WeakReference<ResponseListener> authListener;
    public interface ResponseListener {
        void onResponseReceive(DriverLoginResponse response);
    }

    public void executeAuth(LoginCredentialsHolder holder, ResponseListener listener1)
    {
        authListener = new WeakReference<>(listener1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dev-api.dook.sa:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Log.d(TAG, "Retrofit login object initialized");

        IDriverAuth auth = retrofit.create(IDriverAuth.class);
        Call<DriverLoginResponse> request = auth.executeAuth(holder);
        request.enqueue(new Callback<DriverLoginResponse>() {
            @Override
            public void onResponse(Call<DriverLoginResponse> call, Response<DriverLoginResponse> response)
            {
                DriverLoginResponse loginResponse;
                if (response.isSuccessful())
                {
                    loginResponse = response.body();
                    Log.d(TAG, "Response successfully received");
                }
                else
                {
                    loginResponse = DriverLoginResponse.dummyObject();
                    Log.e(TAG, "Unsuccessful response, wrong credentials");
                }

                ResponseListener listen = authListener.get();
                if (listen != null)
                {
                    Log.d(TAG, "Response sent to presenter");
                    listen.onResponseReceive(loginResponse);
                }

            }

            @Override
            public void onFailure(Call<DriverLoginResponse> call, Throwable t)
            {
                Log.e(TAG, "Failure occurred during execution of Retrofit request", t);

                ResponseListener listen = authListener.get();
                if (listen != null)
                    listen.onResponseReceive(DriverLoginResponse.errorObject());
            }
        });

    }



    private WeakReference<GroupageCallbackListener> groupageCallbackListener;
    public interface GroupageCallbackListener {
        void onGroupagesReceived(List<Groupage> groupage);
    }

    public void execGroupageExtraction(DriverLoginResponse credentials, GroupageCallbackListener listener)
    {
        this.groupageCallbackListener = new WeakReference<>(listener);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dev-api.dook.sa:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Log.d(TAG, "Retrofit login object initialized");

        IGroupageItem groupageItem = retrofit.create(IGroupageItem.class);
        Call<List<Groupage>> request = groupageItem.getGroupages(credentials.getUserId(), credentials.getId());
        request.enqueue(new Callback<List<Groupage>>() {
            @Override
            public void onResponse(Call<List<Groupage>> call, Response<List<Groupage>> response)
            {
                List<Groupage> groupages;
                if (response.isSuccessful())
                {
                    groupages = response.body();
                    Log.d(TAG, "Groupage response successfully received");
                }
                else
                {
                    groupages = new ArrayList<>();
                    groupages.add(Groupage.dummyObject());
                    Log.e(TAG, "Unsuccessfully extracted groupages");
                }

                GroupageCallbackListener listener1 = groupageCallbackListener.get();
                if (listener1 != null)
                {
                    Log.d(TAG, "Groupages response sent to presenter");
                    listener1.onGroupagesReceived(groupages);
                }
            }

            @Override
            public void onFailure(Call<List<Groupage>> call, Throwable t)
            {
                Log.e(TAG, "Failure occurred during execution of Retrofit request", t);

                GroupageCallbackListener listen = groupageCallbackListener.get();
                if (listen != null)
                {
                    List<Groupage> groupages = new ArrayList<>();
                    groupages.add(Groupage.errorObject());
                    listen.onGroupagesReceived(groupages);
                }
            }
        });
    }

}
