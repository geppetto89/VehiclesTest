package android.mobile.micmen.vehiclestest.features.vehicles;

import android.mobile.micmen.vehiclestest.R;
import android.mobile.micmen.vehiclestest.model.Vehicle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class VehiclesDetailActivity extends FragmentActivity {

    public static final String EXTRA_VEHICLE = "EXTRA_VEHICLE";

    private TextView textViewId;
    private TextView textViewVrn;
    private TextView textViewCountry;
    private TextView textViewColor;
    private TextView textViewType;
    private TextView textViewDefault;

    private Vehicle vehicle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicles_detail_activity);
        textViewId = findViewById(R.id.textViewId);
        textViewVrn = findViewById(R.id.textViewVrn);
        textViewCountry = findViewById(R.id.textViewCountry);
        textViewColor = findViewById(R.id.textViewColor);
        textViewType = findViewById(R.id.textViewType);
        textViewDefault = findViewById(R.id.textViewDefault);
        if (getIntent().hasExtra(EXTRA_VEHICLE)) {
            vehicle = getIntent().getParcelableExtra(EXTRA_VEHICLE);
            setUI();
        }
    }

    private void setUI(){
        textViewId.setText(String.format(getResources().getString(R.string.vehicle_id), String.valueOf(vehicle.getId())));
        textViewVrn.setText(String.format(getResources().getString(R.string.vehicles_vrn), vehicle.getVehicleReferenceNumber()));
        textViewCountry.setText(String.format(getResources().getString(R.string.vehicles_country), vehicle.getCountry()));
        textViewColor.setText(String.format(getResources().getString(R.string.vehicles_color), vehicle.getColorName()));
        textViewType.setText(String.format(getResources().getString(R.string.vehicles_type), vehicle.getCarModel().name()));
        textViewDefault.setText(String.format(getResources().getString(R.string.vehicle_customized), String.valueOf(vehicle.isDefaultModel())));
    }
}
