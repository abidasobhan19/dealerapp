package com.forbitbd.Dealer.ui.Device_Entry;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.forbitbd.Dealer.R;
import com.forbitbd.Dealer.utils.AppPreference;


public class DeviceEntryFormFragment extends DialogFragment implements View.OnClickListener ,DeviceEntry_Contract.View{



    private EditText vehicletype,reg_number,device_number,customer_name,customer_number,customer_email,device_id;
    private Button btnsend;
    private DeviceEntry_Presenter mPresenter;
    private  String _id;



    public DeviceEntryFormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new DeviceEntry_Presenter(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_device_entry_form, container, false);





        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.fragment_device_entry_form, null);
        if(AppPreference.getInstance(getContext()).getDealer()!=null){
            _id = AppPreference.getInstance(getContext()).getDealer().get_id();

        }

        vehicletype = view.findViewById(R.id.vehicletype);
        reg_number = view.findViewById(R.id.vehicle_reg);
        device_number= view.findViewById(R.id.device_sim);
        customer_name = view.findViewById(R.id.name);
        customer_number= view.findViewById(R.id.number);
        customer_email =view.findViewById(R.id.email);

        device_id = view.findViewById(R.id.device_id);
        btnsend =view.findViewById(R.id.send_req);
        btnsend.setOnClickListener(this);
        AlertDialog alertDialog = new AlertDialog.Builder(getContext(), R.style.Theme_AppCompat_Dialog_Alert).create();
        alertDialog.setView(view);
        return alertDialog;
    }

    @Override
    public void onClick(View view) {


        String etreg_number= reg_number.getText().toString().trim();
        String etdevice_number = device_number.getText().toString().trim();
        String etcustomer_number = customer_number.getText().toString().trim();
        String etcustomer_email = customer_email.getText().toString().trim();
        String etdevice_id = device_id.getText().toString().trim();
        String etcustomer_name = customer_name.getText().toString().trim();



        mPresenter.device_entry(_id,etreg_number,etdevice_id, etdevice_number,etcustomer_number,etcustomer_email,etcustomer_name);
            dismiss();
    }
}