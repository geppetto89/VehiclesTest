package android.mobile.micmen.vehiclestest.core;

import android.mobile.micmen.vehiclestest.network.ServiceFactory;
import android.mobile.micmen.vehiclestest.network.ServiceFatctoryImpl;
import android.mobile.micmen.vehiclestest.network.VehicleService;
import android.mobile.micmen.vehiclestest.repository.VehiclesRepositoryImpl;

public class RepositoryManager {

    private ServiceFactory serviceFactory;
    public static final String BASE_URL = "http://private-6d86b9-vehicles5.apiary-mock.com/";

    public RepositoryManager() {
        this.serviceFactory = new ServiceFatctoryImpl(BASE_URL);
    }

    public void setServiceFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public VehiclesRepositoryImpl getVehiclesRepository(){
        VehicleService service = serviceFactory.makeService(VehicleService.class);
        return new VehiclesRepositoryImpl(service);
    }

}
