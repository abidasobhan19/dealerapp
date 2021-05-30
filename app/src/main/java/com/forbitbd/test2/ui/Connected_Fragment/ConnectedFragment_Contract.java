package com.forbitbd.test2.ui.Connected_Fragment;

import com.forbitbd.test2.models.Device;

import java.util.List;

public interface ConnectedFragment_Contract {

    interface Presenter{
      void getConnectedDevice(String _id);

    }

    interface View{

        void renderdevice(Device device);

    }
}
