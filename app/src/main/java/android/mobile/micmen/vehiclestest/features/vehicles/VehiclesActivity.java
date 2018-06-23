package android.mobile.micmen.vehiclestest.features.vehicles;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.mobile.micmen.vehiclestest.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

public class VehiclesActivity extends FragmentActivity {

    private RecyclerView recyclerView;
    private VehiclesAdapter vehiclesAdapter;
    private ProgressBar progressBar;
    private VehiclesViewModel vehiclesViewModel;

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
                vehicles -> {
                    if(vehicles!=null) {
                        switch (vehicles.getStatus()) {
                            case SUCCESS:
                                recyclerView.setAdapter(new VehiclesAdapter(vehicles.getData()));
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
                });
    }

    private void setUi() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void showLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }

}
