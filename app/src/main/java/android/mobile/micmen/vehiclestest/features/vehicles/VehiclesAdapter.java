package android.mobile.micmen.vehiclestest.features.vehicles;

import android.mobile.micmen.vehiclestest.R;
import android.mobile.micmen.vehiclestest.model.Vehicle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class VehiclesAdapter extends RecyclerView.Adapter<VehicleViewHolder>{

    private List<Vehicle> vehicles;
    private OnVehicleClickListener vehicleClickListener;


    public VehiclesAdapter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_element, parent, false);
        return new VehicleViewHolder(inflate, vehicleClickListener);
    }

    public void setVehicleClickListener(OnVehicleClickListener vehicleClickListener) {
        this.vehicleClickListener = vehicleClickListener;
    }

    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        holder.onBind(vehicles.get(position));
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

}
