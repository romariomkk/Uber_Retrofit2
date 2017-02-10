package com.romariomkk.uberserviceemulator.model.groupage;

/**
 * Created by romariomkk on 10.02.2017.
 */
public class Groupage {

    private Object groupageDescription;
    private ExpectedPickUpTime expectedPickUpTime;
    private String groupageStatus;
    private Integer deliveryCommission;
    private String id;
    private String createdAt;
    private String updatedAt;
    private String operatorId;
    private String driverId;
    private Double driverReward;
    private Double companyProceeds;
    private String administratorId;


    private static Groupage dummyObject;
    public static Groupage dummyObject()
    {
        if (dummyObject == null)
            dummyObject = new Groupage();
        return dummyObject;
    }

    public boolean isDummyObject()
    {
        return dummyObject != null && this.equals(dummyObject) && this.hashCode() == dummyObject.hashCode();
    }

    private static Groupage errorObject;
    public static Groupage errorObject()
    {
        if (errorObject == null)
            errorObject = new Groupage();
        return errorObject;
    }

    public boolean isErrorObject()
    {
        return errorObject != null && this.equals(errorObject) && this.hashCode() == errorObject.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Groupage)) return false;

        Groupage groupage = (Groupage) o;

        if (groupageDescription != null
                ? !groupageDescription.equals(groupage.groupageDescription)
                : groupage.groupageDescription != null) return false;
        if (expectedPickUpTime != null
                ? !expectedPickUpTime.equals(groupage.expectedPickUpTime)
                : groupage.expectedPickUpTime != null) return false;
        if (groupageStatus != null
                ? !groupageStatus.equals(groupage.groupageStatus)
                : groupage.groupageStatus != null) return false;
        if (deliveryCommission != null
                ? !deliveryCommission.equals(groupage.deliveryCommission)
                : groupage.deliveryCommission != null) return false;
        if (id != null ? !id.equals(groupage.id) : groupage.id != null) return false;
        if (createdAt != null ? !createdAt.equals(groupage.createdAt) : groupage.createdAt != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(groupage.updatedAt) : groupage.updatedAt != null)
            return false;
        if (operatorId != null
                ? !operatorId.equals(groupage.operatorId)
                : groupage.operatorId != null)
            return false;
        if (driverId != null ? !driverId.equals(groupage.driverId) : groupage.driverId != null)
            return false;
        if (driverReward != null
                ? !driverReward.equals(groupage.driverReward)
                : groupage.driverReward != null) return false;
        if (companyProceeds != null
                ? !companyProceeds.equals(groupage.companyProceeds)
                : groupage.companyProceeds != null) return false;
        return administratorId != null
                ? administratorId.equals(groupage.administratorId)
                : groupage.administratorId == null;

    }

    @Override
    public int hashCode()
    {
        int result = groupageDescription != null ? groupageDescription.hashCode() : 0;
        result = 31 * result + (expectedPickUpTime != null ? expectedPickUpTime.hashCode() : 0);
        result = 31 * result + (groupageStatus != null ? groupageStatus.hashCode() : 0);
        result = 31 * result + (deliveryCommission != null ? deliveryCommission.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (driverId != null ? driverId.hashCode() : 0);
        result = 31 * result + (driverReward != null ? driverReward.hashCode() : 0);
        result = 31 * result + (companyProceeds != null ? companyProceeds.hashCode() : 0);
        result = 31 * result + (administratorId != null ? administratorId.hashCode() : 0);
        return result;
    }

    public Object getGroupageDescription() {
        return groupageDescription;
    }
    public void setGroupageDescription(Object groupageDescription) {
        this.groupageDescription = groupageDescription;
    }

    public ExpectedPickUpTime getExpectedPickUpTime() {
        return expectedPickUpTime;
    }
    public void setExpectedPickUpTime(ExpectedPickUpTime expectedPickUpTime) {
        this.expectedPickUpTime = expectedPickUpTime;
    }

    public String getGroupageStatus() {
        return groupageStatus;
    }
    public void setGroupageStatus(String groupageStatus) {
        this.groupageStatus = groupageStatus;
    }

    public Integer getDeliveryCommission() {
        return deliveryCommission;
    }
    public void setDeliveryCommission(Integer deliveryCommission) {
        this.deliveryCommission = deliveryCommission;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getOperatorId() {
        return operatorId;
    }
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getDriverId() {
        return driverId;
    }
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Double getDriverReward() {
        return driverReward;
    }
    public void setDriverReward(Double driverReward) {
        this.driverReward = driverReward;
    }

    public Double getCompanyProceeds() {
        return companyProceeds;
    }
    public void setCompanyProceeds(Double companyProceeds) {
        this.companyProceeds = companyProceeds;
    }

    public String getAdministratorId() {
        return administratorId;
    }
    public void setAdministratorId(String administratorId) {
        this.administratorId = administratorId;
    }

}
