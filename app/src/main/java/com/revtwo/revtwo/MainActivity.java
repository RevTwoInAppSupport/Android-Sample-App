package com.revtwo.revtwo;

import android.os.Bundle;;
import android.support.v7.widget.Toolbar;

import com.revtwo.librevtwo.R2ModeEnum;
import com.revtwo.librevtwo.RevTwo;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 *  MainActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/10/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public class MainActivity extends RActivity {

    private RevTwo revTwo;

    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_new);
    ButterKnife.bind(this);

    revTwo = new RevTwo(this);
    revTwo.r2Intialize("F840AC8B-85D4-2272-F344-F0F0E133BED5", "Fb7RTQzv6nKwtXf2d4ZN39sWV", R2ModeEnum.R2MODE_DEVELOPMENT.getValue());
    /*revTwo.r2CustomizeIncomingCallText("RevTwo calling");
        revTwo.r2CustomizeIncomingCallBackgroundColor("#CDCDCD");
        revTwo.r2CustomizeIncomingCallTextColor("#EEEEEE");
        revTwo.r2CustomizeIncomingCallImage(R.drawable.rev_two_splash_screen);*/
        revTwo.r2RegisterActivityForScreenshot(this);
    showDemoListFragment();

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
