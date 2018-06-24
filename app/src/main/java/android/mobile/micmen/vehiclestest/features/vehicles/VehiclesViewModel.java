package android.mobile.micmen.vehiclestest.features.vehicles;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.mobile.micmen.vehiclestest.core.Resource;
import android.mobile.micmen.vehiclestest.core.VehiclesApplication;
import android.mobile.micmen.vehiclestest.model.Vehicle;
import android.mobile.micmen.vehiclestest.repository.VehiclesRepository;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class VehiclesViewModel extends ViewModel {

    private VehiclesRepository vehiclesRepository;
    private MutableLiveData<Resource<List<Vehicle>>> vehiclesLiveData;
    private Resource<List<Vehicle>> vehiclesResource;
    private CompositeDisposable compositeDisposable;

    public VehiclesViewModel() {
        vehiclesRepository = VehiclesApplication.getInstance().getManager().getVehiclesRepository();
        vehiclesLiveData = new MutableLiveData<>();
        vehiclesResource = new Resource<>(Resource.Status.EMPTY, null, null);
        compositeDisposable = new CompositeDisposable();
    }

    public VehiclesRepository getVehiclesRepository() {
        return vehiclesRepository;
    }

    public void setVehiclesRepository(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }

    public LiveData<Resource<List<Vehicle>>> getVehiclesLiveData() {
        return vehiclesLiveData;
    }

    public void getVehicles() {
        vehiclesResource.setStatus(Resource.Status.LOADING);
        vehiclesLiveData.setValue(vehiclesResource);
        compositeDisposable.add(vehiclesRepository
                .getVehicles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(vehicles -> {
                    vehiclesResource.setStatus(Resource.Status.SUCCESS);
                    vehiclesResource.setData(vehicles);
                    vehiclesLiveData.setValue(vehiclesResource);
                }, throwable -> {
                    vehiclesResource.setStatus(Resource.Status.ERROR);
                    vehiclesResource.setThrowable(throwable);
                    vehiclesLiveData.setValue(vehiclesResource);
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
