package com.forbitbd.test2.ui.Device_Entry;


import android.util.Log;


import com.forbitbd.test2.api.ApiClient;
import com.forbitbd.test2.api.ServiceGenerator;
import com.forbitbd.test2.models.Device;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeviceEntry_Presenter implements DeviceEntry_Contract.Presenter{

    private DeviceEntry_Contract.View mView;

    public DeviceEntry_Presenter(DeviceEntry_Contract.View mView) {
        this.mView = mView;
    }


    @Override
    public void device_entry(String _id,String etreg_number, String etdevice_id,String etdevice_number, String etcustomer_number, String etcustomer_email,String etcustomer_name) {


        Device d = new Device();



            d.setDealer(_id);
            d.setDevice_id(etdevice_id);
            d.setVehicle_reg(etreg_number);

            d.setDevice_sim(etdevice_number);

            d.setCustomer_name(etcustomer_name);

            d.setCustomer_phone(etcustomer_number);

            d.setCustomer_email(etcustomer_email);


        Log.d("jjjjj", "test: "+d.getCustomer_email()+d.getCustomer_name()+d.getCustomer_phone()+d.getDevice_sim()+d.getVehicle_reg() );

        ApiClient client = ServiceGenerator.createService(ApiClient.class);

        Call<Device> call = client.registerDevice(d);

        call.enqueue(new Callback<Device>() {
            @Override
            public void onResponse(Call<Device> call, Response<Device> response) {
                if (response.isSuccessful()){
                    Log.d("jjjjj", "onResponse: "+response.body());
                }
            }

            @Override
            public void onFailure(Call<Device> call, Throwable t) {

            }
        });


    }
}
