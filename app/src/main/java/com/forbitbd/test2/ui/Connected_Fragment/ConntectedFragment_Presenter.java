package com.forbitbd.test2.ui.Connected_Fragment;
import android.util.Log;
import com.forbitbd.test2.api.ApiClient;
import com.forbitbd.test2.api.ServiceGenerator;
import com.forbitbd.test2.models.Device;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConntectedFragment_Presenter implements ConnectedFragment_Contract.Presenter{

    private ConnectedFragment_Contract.View mView;

    public ConntectedFragment_Presenter(ConnectedFragment_Contract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getConnectedDevice(String _id) {

        ApiClient client = ServiceGenerator.createService(ApiClient.class);
        client.getConnectedDevice(_id).enqueue(new Callback<List<Device>>() {
            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {

                if (response.isSuccessful()){
                    Log.d("HHHHHH", "onResponse: "+response.body());

                        List<Device> deviceList = response.body();

                        Log.d("HHHHHH","YES"+deviceList.size());

                        for(Device x: deviceList){
                            mView.renderdevice(x);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {

                Log.d("jjjjjj", "onFailure: "+t.getMessage());

            }
        });


    }
}
