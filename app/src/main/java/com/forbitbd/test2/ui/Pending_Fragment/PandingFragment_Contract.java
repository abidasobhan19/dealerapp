package com.forbitbd.test2.ui.Pending_Fragment;

import com.forbitbd.test2.models.Device;

import java.util.List;

public interface PandingFragment_Contract {

    interface Presenter{
        void getPendingDevice(String _id);
//        void getupdatedevice();
    }

    interface View{

        void getpendingdevice(Device device);
        void updateDevice(List<Device> deviceList);
    }
}
