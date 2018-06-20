
package android.mobile.micmen.vehiclestest.network.dto;

import com.google.gson.annotations.SerializedName;

public class Vehicle {

    @SerializedName("color")
    private String mColor;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("default")
    private Boolean mDefault;
    @SerializedName("type")
    private String mType;
    @SerializedName("vehicleId")
    private Long mVehicleId;
    @SerializedName("vrn")
    private String mVrn;

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public Boolean getDefault() {
        return mDefault;
    }

    public void setDefault(Boolean defaultValue) {
        mDefault = defaultValue;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Long getVehicleId() {
        return mVehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        mVehicleId = vehicleId;
    }

    public String getVrn() {
        return mVrn;
    }

    public void setVrn(String vrn) {
        mVrn = vrn;
    }

}
