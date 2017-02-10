package com.romariomkk.uberserviceemulator.service.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by romariomkk on 10.02.2017.
 */
public class UtilityManager {

    public static class Const
    {
        public static final String RESPONSE_IN_INTENT = "response";
    }

    public static boolean isDeviceOnline()
    {
        ConnectivityManager cm =
                (ConnectivityManager) MainApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

}
