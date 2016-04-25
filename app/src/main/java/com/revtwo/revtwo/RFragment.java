package com.revtwo.revtwo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import butterknife.OnClick;

/*
 *  RFragment.java
 *  RevTwo-Sample-App
 *
 *  Created on 4/12/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public class RFragment extends Fragment {

    protected void setTitle(String title, TextView titleView) {
        titleView.setText(title);
    }

    @Nullable
    @OnClick(R.id.lnrBackButton)
    public void onBack(){
        ((MainActivity)getActivity()).onBackPressed();
    }

    public static boolean showAnimation(){
        return true;
    }

}
