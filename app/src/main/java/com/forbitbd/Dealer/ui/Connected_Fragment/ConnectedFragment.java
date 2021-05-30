package com.forbitbd.Dealer.ui.Connected_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.Dealer.R;
import com.forbitbd.Dealer.models.Device;
import com.forbitbd.Dealer.utils.AppPreference;

import java.util.ArrayList;

public class ConnectedFragment extends Fragment implements ConnectedFragment_Contract.View {

    private RecyclerView recyclerView;
    private ArrayList<Device> deviceList;
    private ConnectedAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private ConntectedFragment_Presenter mPresenter;

    public ConnectedFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ConntectedFragment_Presenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_connected, container, false);
        String _id= AppPreference.getInstance(getContext()).getDealer().get_id();
        mPresenter.getConnectedDevice(_id);
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        deviceList = new ArrayList<>();

        adapter = new ConnectedAdapter(getContext(), deviceList);
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
    }

    @Override
    public void renderdevice(Device device) {
        adapter.add(device);

    }





    }
