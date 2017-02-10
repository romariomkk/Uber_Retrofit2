package com.romariomkk.uberserviceemulator.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.romariomkk.uberserviceemulator.R;
import com.romariomkk.uberserviceemulator.model.auth.DriverLoginResponse;
import com.romariomkk.uberserviceemulator.model.groupage.Groupage;
import com.romariomkk.uberserviceemulator.service.ResponsePresenter;
import com.romariomkk.uberserviceemulator.service.RetrofitManager;
import com.romariomkk.uberserviceemulator.service.utils.MainApplication;
import com.romariomkk.uberserviceemulator.service.utils.UtilityManager;

import java.util.List;

public class GroupagesActivity extends AppCompatActivity implements ResponseView {

    private static final String TAG = GroupagesActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private ResponsePresenter presenterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupages);

        recyclerView = (RecyclerView) findViewById(R.id.groupagesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        DriverLoginResponse credentials = (DriverLoginResponse)intent
                .getSerializableExtra(UtilityManager.Const.RESPONSE_IN_INTENT);

        Log.d(TAG, "Credentials received from intent");

        presenterManager = new ResponsePresenter(this);
        if (UtilityManager.isDeviceOnline())
            presenterManager.requestGroupages(credentials);
        else
            Toast.makeText(GroupagesActivity.this, "Check your network connection and try again", Toast.LENGTH_LONG).show();
    }

    @Override
    public void notifySuccessfulResponse(DriverLoginResponse driverLoginResponse)
    {
        //nothing
    }

    @Override
    public void notifySuccessfulResponse(List<Groupage> groupages)
    {
        if (groupages.get(0).isDummyObject())
        {
            Toast.makeText(GroupagesActivity.this, "You entered wrong credentials.\nTry again",
                    Toast.LENGTH_LONG).show();
        }
        else if (groupages.get(0).isErrorObject())
        {
            Toast.makeText(GroupagesActivity.this, "Server error occurred.\n Please try again later", Toast.LENGTH_SHORT).show();
        }
        else
        {
            recyclerView.setAdapter(new GroupageListAdapter(this, groupages));
        }
    }
}
