package com.forbitbd.Dealer.ui.Pending_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.Dealer.R;
import com.forbitbd.Dealer.models.Device;
import com.forbitbd.Dealer.utils.AppPreference;

import java.util.ArrayList;
import java.util.List;

public class Fragment_panding extends Fragment implements PandingFragment_Contract.View {

    private RecyclerView recyclerView;
    private ArrayList<Device> deviceList;
    private PendingAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private PendingFragment_Presenter mPresenter;

    public Fragment_panding() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PendingFragment_Presenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       String _id = AppPreference.getInstance(getContext()).getDealer().get_id();

        Log.d("HHHHHH", "onCreateView: "+_id);

        View view = inflater.inflate(R.layout.fragment_panding, container, false);
        mPresenter.getPendingDevice(_id);
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        deviceList = new ArrayList<>();
        //deviceList.add(new Device("Dhaka Metro 12-5783", "Truck", "01824465858", "Saimul Hoque", "01881269553", "saimulhqoue8217@gmail.com"));
        adapter = new PendingAdapter(getContext(), deviceList);
        recyclerView.setAdapter(adapter);

        refreshLayout = view.findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
                refreshData();
            }
        });
        return view;
    }

    private void refreshData() {
        refreshLayout.setRefreshing(false);
//        mPresenter.getupdatedevice();








    }


    @Override
    public void getpendingdevice(Device device) {
        adapter.add(device);

    }

    @Override
    public void updateDevice(List<Device> deviceList) {

        for (Device device : deviceList){
            adapter.update(device);
        }

    }


}