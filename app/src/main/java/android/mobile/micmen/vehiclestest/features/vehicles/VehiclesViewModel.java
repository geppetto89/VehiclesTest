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
    private MutableLiveData<Resource<List<Vehicle>>> vehiclesLiveData = new MutableLiveData<>();
    private Resource<List<Vehicle>> vehiclesResource = new Resource<>(Resource.Status.EMPTY, null, null);
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public VehiclesViewModel() {
        vehiclesRepository = VehiclesApplication.getInstance().getManager().getVehiclesRepository();
    }

    public LiveData<Resource<List<Vehicle>>> getVehiclesLiveData() {
        return vehiclesLiveData;
    }

    public void getVehicles(){
        vehiclesResource.setStatus(Resource.Status.LOADING);
        vehiclesLiveData.setValue(vehiclesResource);
        compositeDisposable.add(vehiclesRepository
                .getVehicles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(vehicles -> {
                    vehiclesResource.setData(vehicles);
                    vehiclesResource.setStatus(Resource.Status.SUCCESS);
                    vehiclesLiveData.setValue(vehiclesResource);
                }, throwable -> {
                    vehiclesResource.setThrowable(throwable);
                    vehiclesResource.setStatus(Resource.Status.ERROR);
                    vehiclesLiveData.setValue(vehiclesResource);
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
