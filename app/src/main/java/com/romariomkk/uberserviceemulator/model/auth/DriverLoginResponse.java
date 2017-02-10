package com.romariomkk.uberserviceemulator.model.auth;

import java.io.Serializable;

/**
 * Created by romariomkk on 10.02.2017.
 */
public class DriverLoginResponse implements Serializable {

    private String id;
    private Integer ttl;
    private String created;
    private String userId;

    private static DriverLoginResponse dummyObject;

    public static DriverLoginResponse dummyObject()
    {
        if (dummyObject == null)
            dummyObject = new DriverLoginResponse();
        return dummyObject;
    }

    public boolean isDummyObject()
    {
        return dummyObject != null && this.equals(dummyObject) && this.hashCode() == dummyObject.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof DriverLoginResponse)) return false;

        DriverLoginResponse that = (DriverLoginResponse) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ttl != null ? !ttl.equals(that.ttl) : that.ttl != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;

    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ttl != null ? ttl.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integer getTtl()
    {
        return ttl;
    }

    public void setTtl(Integer ttl)
    {
        this.ttl = ttl;
    }

    public String getCreated()
    {
        return created;
    }

    public void setCreated(String created)
    {
        this.created = created;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    private static DriverLoginResponse errorObject;

    public static DriverLoginResponse errorObject()
    {
        if (errorObject == null)
            errorObject = new DriverLoginResponse();
        return errorObject;
    }

    public boolean isErrorObject()
    {
        return errorObject != null && this.equals(errorObject) && this.hashCode() == errorObject.hashCode();
    }
}

