package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.revtwo.librevtwo.RevTwo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 *  LoggingActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/10/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public class LoggingActivity extends RFragment {
    private RevTwo revTwo;
    @Bind(R.id.tlbActionBar)
    Toolbar myToolbar;
    @Bind(R.id.txtTitle)
    TextView title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_logging, null);
        ButterKnife.bind(this, view);

        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolbar);

        this.setTitle(this.getString(R.string.title_logging), title);

        revTwo = new RevTwo(this.getContext());
        revTwo.r2RegisterActivityForScreenshot(this.getActivity());

        return view;
    }

    @OnClick(R.id.btnTraceLog)
    public void sendTraceLog(){
        revTwo.r2Trace("Trace Log Message");

    }
    @OnClick(R.id.btnDebugLog)
    public void sendDebugLog(){
        revTwo.r2Debug("Debug Log Message");

    }
    @OnClick(R.id.btnWarningLog)
    public void sendWarningLog(){
        revTwo.r2Warn("Warning Log Message");
    }
    @OnClick(R.id.btnErrorLog)
    public void sendErrorLog(){
        revTwo.r2Error("Error Log Message");
    }

}
