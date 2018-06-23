package android.mobile.micmen.vehiclestest.features.vehicles;

import android.mobile.micmen.vehiclestest.R;
import android.mobile.micmen.vehiclestest.model.Vehicle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class VehicleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView vehicleName;
    private Vehicle vehicle;
    private OnVehicleClickListener vehicleClickListener;

    public VehicleViewHolder(View itemView, OnVehicleClickListener listener) {
        super(itemView);
        vehicleName = itemView.findViewById(R.id.vehicles_name);
        vehicleClickListener = listener;
        itemView.setOnClickListener(this);
    }

    public void onBind(Vehicle vehicle) {
        this.vehicle = vehicle;
        if (vehicle.getVehicleReferenceNumber() != null) {
            vehicleName.setText(vehicle.getVehicleReferenceNumber());
        }
    }

    @Override
    public void onClick(View v) {
        if (vehicleClickListener != null && vehicle!=null) {
            vehicleClickListener.onVehicleClicked(vehicle);
        }
    }
}
