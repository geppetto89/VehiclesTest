package android.mobile.micmen.vehiclestest.model;

public class Vehicle {

    public Vehicle(String vehicleReferenceNumber, CarModel carModel, String colorName, String country, boolean isDefaultModel) {
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

    enum CarModel {
        TRUCK, RV, CAR
    }

    private String vehicleReferenceNumber;

    private CarModel carModel;

    private String colorName;

    private String country;

    private boolean isDefaultModel;



}
