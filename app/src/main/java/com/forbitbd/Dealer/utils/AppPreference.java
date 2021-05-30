package com.forbitbd.Dealer.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.forbitbd.Dealer.models.Dealer;

public class AppPreference {


    private static final String SP_NAME="SSSPPP";

    private static final String _ID="_ID";
    private static final String NAME="NAME";
    private static final String EMAIL="EMAIL";
    private static final String MOBILE="MOBILE";
    private static final String IMAGE="IMAGE";
    private static final String ADDRESS="ADDRESS";
    private static final String ORGANIZATION_NAME="ORGANIZATION_NAME";
    private static final String FCM_TOKEN="FCM_TOKEN";
    private static final String IS_ACTIVE="IS_ACTIVE";



    private static AppPreference appPreference = null;


    SharedPreferences sp;

    private AppPreference(Context context) {
        sp = context.getSharedPreferences(SP_NAME,context.MODE_PRIVATE);
    }

    public static AppPreference getInstance(Context context){
        if(appPreference==null){
            appPreference = new AppPreference(context);
        }
        return appPreference;
    }


    public void setDealer(Dealer dealer){
        SharedPreferences.Editor editor = sp.edit();
        if(dealer==null){
            editor.putString(_ID,null);
            editor.putString(NAME,null);
            editor.putString(EMAIL,null);
            editor.putString(MOBILE,null);
            editor.putString(IMAGE,null);
            editor.putString(ADDRESS,null);
            editor.putString(ORGANIZATION_NAME,null);
            editor.putString(FCM_TOKEN,null);
            editor.putBoolean(IS_ACTIVE,false);

        }else{
            editor.putString(_ID,dealer.get_id());
            editor.putString(NAME,dealer.getName());
            editor.putString(EMAIL,dealer.getEmail());
            editor.putString(MOBILE,dealer.getMobile());
            editor.putString(IMAGE,dealer.getImage());
            editor.putString(ADDRESS,dealer.getAddress());
            editor.putString(ORGANIZATION_NAME,dealer.getOrganization_name());
            editor.putString(FCM_TOKEN,dealer.getFcm_token());
            editor.putBoolean(IS_ACTIVE,dealer.getIs_active());
        }

        editor.apply();

    }


    public Dealer getDealer(){
        Dealer dealer = new Dealer();
        dealer.set_id(sp.getString(_ID,null));
        dealer.setName(sp.getString(NAME,null));
        dealer.setEmail(sp.getString(EMAIL,null));
        dealer.setMobile(sp.getString(MOBILE,null));
        dealer.setImage(sp.getString(IMAGE,null));
        dealer.setAddress(sp.getString(ADDRESS,null));
        dealer.setOrganization_name(sp.getString(ORGANIZATION_NAME,null));
        dealer.setFcm_token(sp.getString(FCM_TOKEN,null));
        dealer.setIs_active(sp.getBoolean(IS_ACTIVE,false));

        return dealer;
    }



}
