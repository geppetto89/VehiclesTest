package android.mobile.micmen.vehiclestest;

import android.mobile.micmen.vehiclestest.core.RepositoryManager;
import android.mobile.micmen.vehiclestest.features.vehicles.VehiclesActivity;
import android.mobile.micmen.vehiclestest.network.ServiceFatctoryImpl;
import android.mobile.micmen.vehiclestest.repository.VehiclesRepositoryImpl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

public class VehicleRepositoryTest {

    @Test
    public void testVehiclesCallSuccess(){
        RepositoryManager serviceManager = new RepositoryManager();
        VehiclesRepositoryImpl vehiclesRepository = serviceManager.getVehiclesRepository();
        vehiclesRepository.getVehicles()
                .blockingSubscribe(
                        Assert::assertNotNull);
    }

    @Test
    public void testVehiclesCallFailure(){
        RepositoryManager serviceManager = new RepositoryManager();
        ServiceFatctoryImpl serviceFatctory = new ServiceFatctoryImpl("http://private-wrong-mock.com/");
        serviceManager.setServiceFactory(serviceFatctory);
        VehiclesRepositoryImpl vehiclesRepository = serviceManager.getVehiclesRepository();
        vehiclesRepository.getVehicles()
                .blockingSubscribe(
                        vehicles -> {},
                        Assert::assertNotNull);
    }

}
