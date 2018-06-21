package android.mobile.micmen.vehiclestest.core;

import android.app.Application;

public class VehiclesApplication extends Application {

    private RepositoryManager manager;
    private static VehiclesApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        manager = new RepositoryManager();
    }

    public static VehiclesApplication getInstance() {
        return instance;
    }

    public RepositoryManager getManager() {
        return manager;
    }
}
