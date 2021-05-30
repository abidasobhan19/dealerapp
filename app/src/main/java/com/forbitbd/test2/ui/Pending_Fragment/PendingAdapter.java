package com.forbitbd.test2.ui.Pending_Fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbitbd.test2.R;
import com.forbitbd.test2.models.Device;
import com.google.firebase.database.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.MyHolder> {

    private Context context;
    private List<Device> deviceList;

    public PendingAdapter(Context context, List<Device> deviceList) {
        this.context = context;
        this.deviceList = deviceList;
    }

    @NonNull
    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_devices,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
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


    public void update(Device device) {
        int position = getPosition(device);
        if (position != -1) {
            deviceList.set(position, device);
            notifyItemChanged(position);
            Log.d("TAG", "update: "+ device.getDevice_id());
        }
    }


    private int getPosition(Device device) {
        int retVal = -1;
        for (Device x: deviceList){
            if(x.getDevice_id().equals(device.getDevice_id())){
                retVal = deviceList.indexOf(x);
                break;
            }
        }
        return retVal;

    }


    public class MyHolder extends RecyclerView.ViewHolder {

        TextView tv1, tv2, tv3, tv4, tv5, tv6;

        public MyHolder(@NonNull @NotNull View itemView) {
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
