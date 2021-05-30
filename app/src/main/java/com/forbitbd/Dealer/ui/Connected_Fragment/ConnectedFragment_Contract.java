package com.forbitbd.Dealer.ui.Connected_Fragment;

import com.forbitbd.Dealer.models.Device;

public interface ConnectedFragment_Contract {

    interface Presenter{
      void getConnectedDevice(String _id);

    }

    interface View{

        void renderdevice(Device device);

    }
}
