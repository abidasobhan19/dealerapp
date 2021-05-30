package com.forbitbd.Dealer.ui.Connected_Fragment;
import com.forbitbd.Dealer.api.ApiClient;
import com.forbitbd.Dealer.api.ServiceGenerator;
import com.forbitbd.Dealer.models.Device;
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
                        List<Device> deviceList = response.body();
                        for(Device x: deviceList){
                            mView.renderdevice(x);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {


            }
        });

    }
}
