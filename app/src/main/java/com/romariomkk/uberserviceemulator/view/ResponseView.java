package com.romariomkk.uberserviceemulator.view;

import com.romariomkk.uberserviceemulator.model.auth.DriverLoginResponse;
import com.romariomkk.uberserviceemulator.model.groupage.Groupage;

import java.util.List;

/**
 * Created by romariomkk on 10.02.2017.
 */
public interface ResponseView {

    void notifySuccessfulResponse(DriverLoginResponse driverLoginResponse);
    void notifySuccessfulResponse(List<Groupage> groupages);

}
