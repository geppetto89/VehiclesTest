package android.mobile.micmen.vehiclestest.network;

import android.mobile.micmen.vehiclestest.network.dto.VehiclesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface VehicleService {

    @GET("vehicles")
    Observable<VehiclesResponse> getVehicles();

}
