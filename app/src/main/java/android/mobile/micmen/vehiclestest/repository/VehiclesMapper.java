package android.mobile.micmen.vehiclestest.repository;

import android.mobile.micmen.vehiclestest.core.Mapper;
import android.mobile.micmen.vehiclestest.model.Vehicle;
import android.mobile.micmen.vehiclestest.network.dto.VehiclesResponse;
import android.mobile.micmen.vehiclestest.util.VehiclesUtils;

import java.util.ArrayList;
import java.util.List;

public class VehiclesMapper implements Mapper<VehiclesResponse, List<Vehicle>> {
    @Override
    public List<Vehicle> map(VehiclesResponse response) {
        List<Vehicle> list = new ArrayList<>();
        for (android.mobile.micmen.vehiclestest.network.dto.Vehicle vehicle : response.getVehicles()) {
            list.add(new Vehicle(vehicle.getVrn(), VehiclesUtils.getVehichleTypeByName(vehicle.getType()), vehicle.getColor(), vehicle.getCountry(), vehicle.getDefault()));
        }
        return list;
    }
}
