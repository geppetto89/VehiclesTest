package android.mobile.micmen.vehiclestest.features.vehicles;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.mobile.micmen.vehiclestest.R;
import android.mobile.micmen.vehiclestest.core.Resource;
import android.mobile.micmen.vehiclestest.model.Vehicle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

public class VehiclesActivity extends FragmentActivity {

    private RecyclerView recyclerView;
    private VehiclesAdapter vehiclesAdapter;
    private ProgressBar progressBar;
    private VehiclesViewModel vehiclesViewModel;

   private Observer<Resource<List<Vehicle>>> resourceObserver = vehicles -> {
        if (vehicles != null) {
            switch (vehicles.getStatus()) {
                case SUCCESS:
                    hideLoader();
                    vehiclesAdapter.setVehicles(vehicles.getData());
                    break;
                case ERROR:
                    hideLoader();
                    break;
                case LOADING:
                    showLoader();
                    break;
                case EMPTY:
                    //
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicles_activity);
        vehiclesViewModel = ViewModelProviders.of(this).get(VehiclesViewModel.class);
        recyclerView = findViewById(R.id.vehicles_list);
        progressBar = findViewById(R.id.progress_bar);
        setUi();
        retrieveVechiles();
    }

    private void retrieveVechiles() {
        vehiclesViewModel.getVehicles();
        vehiclesViewModel.getVehiclesLiveData().observe(this,
                resourceObserver);
    }

    private void setUi() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        vehiclesAdapter = new VehiclesAdapter(vehicleClickListener);
        recyclerView.setAdapter(vehiclesAdapter);
    }

    private void showLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }

    private OnVehicleClickListener vehicleClickListener = vehicle -> {
        Intent intent = new Intent();
        intent.setClass(this, VehiclesDetailActivity.class);
        intent.putExtra(VehiclesDetailActivity.EXTRA_VEHICLE, vehicle);
        startActivity(intent);
    };
}
