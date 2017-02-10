package com.romariomkk.uberserviceemulator.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.romariomkk.uberserviceemulator.R;
import com.romariomkk.uberserviceemulator.model.auth.DriverLoginResponse;
import com.romariomkk.uberserviceemulator.model.groupage.Groupage;
import com.romariomkk.uberserviceemulator.service.ResponsePresenter;
import com.romariomkk.uberserviceemulator.service.RetrofitManager;
import com.romariomkk.uberserviceemulator.service.utils.MainApplication;
import com.romariomkk.uberserviceemulator.service.utils.UtilityManager;

import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements ResponseView {

    private AutoCompleteTextView emailView;
    private EditText passwordView;
    private View progressView;
    private View loginFormView;

    private ResponsePresenter presentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presentManager = new ResponsePresenter(this);

        emailView = (AutoCompleteTextView) findViewById(R.id.email);
        passwordView = (EditText) findViewById(R.id.password);

        Button emailSignInButton = (Button) findViewById(R.id.sign_in_button);
        emailSignInButton.setOnClickListener(view -> attemptLogin());

        loginFormView = findViewById(R.id.login_form);
        progressView = findViewById(R.id.login_progress);
    }


    private void attemptLogin()
    {
        emailView.setError(null);
        passwordView.setError(null);

        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (isPassValid(password))
        {
            passwordView.setError(getString(R.string.error_invalid_password));
            focusView = passwordView;
            cancel = true;
        }

        if (TextUtils.isEmpty(email))
        {
            emailView.setError(getString(R.string.error_field_required));
            focusView = emailView;
            cancel = true;
        }
        else if (!isEmailValid(email))
        {
            emailView.setError(getString(R.string.error_invalid_email));
            focusView = emailView;
            cancel = true;
        }

        if (cancel)
        {
            focusView.requestFocus();
        }
        else
        {
            showProgress(true);
            if (UtilityManager.isDeviceOnline())
                presentManager.requestAuth(email, password);
            else
                Toast.makeText(LoginActivity.this, "Check your network connection and try again", Toast.LENGTH_LONG).show();

        }
    }

    private boolean isPassValid(String password)
    {
        return password.isEmpty() && !isPasswordValid(password);
    }

    private boolean isEmailValid(String email)
    {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password)
    {
        return password.length() > 4;
    }

    //Standard pre-compiled method, learnt and left by romariomkk
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2)
        {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            loginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation)
                {
                    loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation)
                {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        }
        else
        {
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void notifySuccessfulResponse(DriverLoginResponse response)
    {
        if (response.isDummyObject())
        {
            showProgress(false);
            Toast.makeText(LoginActivity.this, "You entered wrong credentials.\nTry again",
                    Toast.LENGTH_LONG).show();
        }
        else if (response.isErrorObject())
        {
            showProgress(false);
            Toast.makeText(LoginActivity.this, "Server error occurred.\n Please try again later", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this, GroupagesActivity.class);
            intent.putExtra("response", response);
            startActivity(intent);
        }
    }

    @Override
    public void notifySuccessfulResponse(List<Groupage> groupages)
    {
        //nothing
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        showProgress(false);
    }
}

