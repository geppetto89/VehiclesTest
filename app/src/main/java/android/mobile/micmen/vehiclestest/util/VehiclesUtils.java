package android.mobile.micmen.vehiclestest.util;

import android.mobile.micmen.vehiclestest.model.Vehicle;

public class VehiclesUtils {


    public static Vehicle.CarModel getVehichleTypeByName(String vr) {
        switch (vr) {
            case "Truck":
                return Vehicle.CarModel.TRUCK;
            case "RV":
                return Vehicle.CarModel.RV;
            case "Car":
                return Vehicle.CarModel.CAR;
            default:
                return Vehicle.CarModel.UNDEFINED;
        }
    }

}
