package com.forbitbd.Dealer.ui.Welcome_Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.forbitbd.Dealer.R;


public class Welcome_Fragment  extends androidx.fragment.app.DialogFragment  implements View.OnClickListener {


    private Button btnok;

    private WelcomeListener listener;



    public Welcome_Fragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.listener = (WelcomeListener) getActivity();




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome_, container, false);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.fragment_welcome_, null);

        btnok = view.findViewById(R.id.btnok);
        btnok.setOnClickListener(this);

        AlertDialog alertDialog = new AlertDialog.Builder(getContext(),R.style.Theme_AppCompat_Dialog_Alert).create();
        alertDialog.setView(view);
        return alertDialog;
    }

    @Override
    public void onClick(View view) {
        if (view==btnok){
            if(listener!=null){
                listener.signOut();
            }
            dismiss();

            getActivity().finish();

        }
    }
}
