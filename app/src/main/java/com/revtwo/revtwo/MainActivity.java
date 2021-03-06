package com.revtwo.revtwo;

import android.os.Bundle;

import com.revtwo.revtwolib.RevTwo;

import butterknife.ButterKnife;
import com.revtwo.revtwolib.models.responses.CreateTicketResponse;

;

/*
 *  MainActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/10/2016.
 *  Copyright (c) 2015-2019 RevTwo, Inc. All rights reserved.
 */
public class MainActivity extends RActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        ButterKnife.bind(this);
        showDemoListFragment();

        RevTwo.registerActivityForScreenshare(this);

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
