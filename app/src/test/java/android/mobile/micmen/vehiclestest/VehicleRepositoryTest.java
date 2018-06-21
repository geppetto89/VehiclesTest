package android.mobile.micmen.vehiclestest;

import android.mobile.micmen.vehiclestest.core.RepositoryManager;
import android.mobile.micmen.vehiclestest.repository.VehiclesRepositoryImpl;

import org.junit.Assert;
import org.junit.Test;

public class VehicleRepositoryTest {

    @Test
    public void testVehiclesCall(){
        RepositoryManager serviceManager = new RepositoryManager();
        VehiclesRepositoryImpl vehiclesRepository = serviceManager.getVehiclesRepository();
        vehiclesRepository.getVehicles()
                .blockingSubscribe(
                        vehicles -> {
                            Assert.assertNotNull(vehicles);
                });
    }

}
