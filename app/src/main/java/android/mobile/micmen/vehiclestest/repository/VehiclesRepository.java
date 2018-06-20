package android.mobile.micmen.vehiclestest.repository;

import android.mobile.micmen.vehiclestest.model.Vehicle;

import java.util.List;

import io.reactivex.Observable;

public interface VehiclesRepository {

    Observable<List<Vehicle>> getVehicles();

}
