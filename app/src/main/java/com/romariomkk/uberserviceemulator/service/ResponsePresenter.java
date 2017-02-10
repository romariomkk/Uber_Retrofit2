package com.romariomkk.uberserviceemulator.service;

import android.content.Context;

import com.romariomkk.uberserviceemulator.model.auth.DriverLoginResponse;
import com.romariomkk.uberserviceemulator.model.auth.LoginCredentialsHolder;
import com.romariomkk.uberserviceemulator.model.groupage.Groupage;
import com.romariomkk.uberserviceemulator.service.utils.MainApplication;
import com.romariomkk.uberserviceemulator.view.ResponseView;

import java.util.List;

/**
 * Created by romariomkk on 10.02.2017.
 */
public class ResponsePresenter {

    private ResponseView view;

    RetrofitManager manager = MainApplication.getInstance().getRequestManager();

    public ResponsePresenter(ResponseView view)
    {
        this.view = view;
    }

    public void requestAuth(String email, String password){
        LoginCredentialsHolder holder = LoginCredentialsHolder.newInstance(email, password);
        manager.executeAuth(holder, new RetrofitManager.ResponseListener() {
            @Override
            public void onResponseReceive(DriverLoginResponse response)
            {
                view.notifySuccessfulResponse(response);
            }
        });
    }


    public void requestGroupages(DriverLoginResponse credentials)
    {
        manager.execGroupageExtraction(credentials, new RetrofitManager.GroupageCallbackListener() {
            @Override
            public void onGroupagesReceived(List<Groupage> groupages)
            {
                view.notifySuccessfulResponse(groupages);
            }
        });
    }

}
