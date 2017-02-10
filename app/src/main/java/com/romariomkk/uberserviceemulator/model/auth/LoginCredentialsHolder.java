package com.romariomkk.uberserviceemulator.model.auth;

/**
 * Created by romariomkk on 10.02.2017.
 */
public class LoginCredentialsHolder {

    private String email;
    private String password;

    public static LoginCredentialsHolder newInstance(String email, String password)
    {
        return new LoginCredentialsHolder(email, password);
    }

    private LoginCredentialsHolder(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
