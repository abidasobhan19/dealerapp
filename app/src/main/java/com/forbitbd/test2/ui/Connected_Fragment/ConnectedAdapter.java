package com.forbitbd.test2.ui.Connected_Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.test2.R;
import com.forbitbd.test2.models.Device;

import java.util.List;

public class ConnectedAdapter extends RecyclerView.Adapter<ConnectedAdapter.MyViewHolder> {

    private Context context;
    private List<Device> deviceList;

    public ConnectedAdapter(Context context, List<Device> deviceList) {
        this.context = context;
        this.deviceList = deviceList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_devices,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Device device = deviceList.get(position);
        holder.bind(device);
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public void add(Device device) {
        deviceList.add(device);
        int position = deviceList.indexOf(device);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1, tv2, tv3, tv4, tv5, tv6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.vehicle_reg);
            tv2 = itemView.findViewById(R.id.vehicle_type);
            tv3 = itemView.findViewById(R.id.device_sim);
            tv4 = itemView.findViewById(R.id.customer_name);
            tv5 = itemView.findViewById(R.id.customer_phone);
            tv6 = itemView.findViewById(R.id.customer_email);

        }

        public void bind(Device device) {
            tv1.setText(device.getVehicle_reg());
            tv2.setText(device.getVehicle_type());
            tv3.setText(device.getDevice_sim());
            tv4.setText(device.getCustomer_name());
            tv5.setText(device.getCustomer_phone());
            tv6.setText(device.getCustomer_email());
        }
    }
}