package android.mobile.micmen.vehiclestest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String vehicleReferenceNumber;

    private CarModel carModel;

    private String colorName;

    private String country;

    private boolean isDefaultModel;

    public Vehicle(long id, String vehicleReferenceNumber, CarModel carModel, String colorName, String country, boolean isDefaultModel) {
        this.id = id;
        this.vehicleReferenceNumber = vehicleReferenceNumber;
        this.carModel = carModel;
        this.colorName = colorName;
        this.country = country;
        this.isDefaultModel = isDefaultModel;
    }

    public String getVehicleReferenceNumber() {
        return vehicleReferenceNumber;
    }

    public void setVehicleReferenceNumber(String vehicleReferenceNumber) {
        this.vehicleReferenceNumber = vehicleReferenceNumber;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isDefaultModel() {
        return isDefaultModel;
    }

    public void setDefaultModel(boolean defaultModel) {
        isDefaultModel = defaultModel;
    }

    public enum CarModel {
        TRUCK, RV, CAR, UNDEFINED
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.vehicleReferenceNumber);
        dest.writeInt(this.carModel == null ? -1 : this.carModel.ordinal());
        dest.writeString(this.colorName);
        dest.writeString(this.country);
        dest.writeByte(this.isDefaultModel ? (byte) 1 : (byte) 0);
    }

    protected Vehicle(Parcel in) {
        this.id = in.readLong();
        this.vehicleReferenceNumber = in.readString();
        int tmpCarModel = in.readInt();
        this.carModel = tmpCarModel == -1 ? null : CarModel.values()[tmpCarModel];
        this.colorName = in.readString();
        this.country = in.readString();
        this.isDefaultModel = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Vehicle> CREATOR = new Parcelable.Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel source) {
            return new Vehicle(source);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };
}
