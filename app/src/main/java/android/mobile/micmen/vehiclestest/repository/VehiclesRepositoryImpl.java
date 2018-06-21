package android.mobile.micmen.vehiclestest.repository;

import android.mobile.micmen.vehiclestest.model.Vehicle;
import android.mobile.micmen.vehiclestest.network.VehicleService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class VehiclesRepositoryImpl implements VehiclesRepository {

    private VehicleService vehicleService;
    private VehiclesMapper mapper = new VehiclesMapper();

    public VehiclesRepositoryImpl(VehicleService service) {
        this.vehicleService = service;
    }

    @Override
    public Observable<List<Vehicle>> getVehicles() {
        return vehicleService
                .getVehicles()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(response -> mapper.map(response));
    }


}
