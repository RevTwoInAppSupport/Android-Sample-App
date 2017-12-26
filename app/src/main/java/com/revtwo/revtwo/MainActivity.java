package com.revtwo.revtwo;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

import com.revtwo.revtwolib.RevTwo;
import com.revtwo.revtwolibcore.CallReceiverService;

import butterknife.ButterKnife;

;

/*
 *  MainActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/10/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public class MainActivity extends RActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        ButterKnife.bind(this);
        showDemoListFragment();

        registerReceiver();
        RevTwo.registerActivityForScreenshare(this);
    }

    private void registerReceiver() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            BroadcastReceiver broadcastReceiver = new CustomNotificationReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.revtwo.action.NOTIFICATION");

            CallReceiverService.registerBroadcastReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }

    public void showFragment(Class<? extends RFragment> fragmentClass){
         showNewFragment(fragmentClass,R.id.activity_main_new_container,true);
     }

    public void showDemoListFragment(){
         showFragment(DemoListFragment.class);
    }


}
