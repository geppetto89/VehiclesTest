package android.mobile.micmen.vehiclestest;

import android.mobile.micmen.vehiclestest.network.dto.VehiclesResponse;
import android.mobile.micmen.vehiclestest.repository.VehiclesMapper;

import com.google.gson.Gson;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Gson.class)
public class MapperTest {

    @Test
    public void testMapper() {
        VehiclesResponse mockedResponse = new VehiclesResponse();
        String json = "{\n" +
                "    \"count\":5,\n" +
                "    \"vehicles\":\n" +
                "    [\n" +
                "        {\n" +
                "            \"vehicleId\":107623,\n" +
                "            \"vrn\":\"PARK01\",\n" +
                "            \"country\":\"GB\",\n" +
                "            \"color\":\"Blue\",\n" +
                "            \"type\":\"Truck\",\n" +
                "            \"default\":true\n" +
                "        },\n" +
                "        {\n" +
                "            \"vehicleId\":107523,\n" +
                "            \"vrn\":\"PARK02\",\n" +
                "            \"country\":\"ES\",\n" +
                "            \"color\":\"White\",\n" +
                "            \"type\":\"RV\",\n" +
                "            \"default\":false\n" +
                "        },\n" +
                "        {\n" +
                "            \"vehicleId\":107613,\n" +
                "            \"vrn\":\"PARK03\",\n" +
                "            \"country\":\"NL\",\n" +
                "            \"color\":\"Red\",\n" +
                "            \"type\":\"Car\",\n" +
                "            \"default\":false\n" +
                "        },\n" +
                "        {\n" +
                "            \"vehicleId\":117623,\n" +
                "            \"vrn\":\"PARK04\",\n" +
                "            \"country\":\"NL\",\n" +
                "            \"color\":\"Black\",\n" +
                "            \"type\":\"Car\",\n" +
                "            \"default\":false\n" +
                "        },\n" +
                "        {\n" +
                "            \"vehicleId\":107627,\n" +
                "            \"vrn\":\"PARK05\",\n" +
                "            \"country\":\"NL\",\n" +
                "            \"color\":\"Blue\",\n" +
                "            \"type\":\"Truck\",\n" +
                "            \"default\":false\n" +
                "        }\n" +
                "    ],\n" +
                "    \"currentPage\":1,\n" +
                "    \"nextPage\":1,\n" +
                "    \"totalPages\":1\n" +
                "}";
        Gson gson = new Gson();
        mockedResponse = gson.fromJson(json, VehiclesResponse.class);
        VehiclesMapper mapper = new VehiclesMapper();
        Assert.assertNotNull(mapper.map(mockedResponse));

    }

}
