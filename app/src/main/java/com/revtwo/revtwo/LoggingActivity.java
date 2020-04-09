package com.revtwo.revtwo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.revtwo.revtwolib.RevTwo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 *  LoggingActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/10/2016.
 *  Copyright (c) 2015-2019 RevTwo, Inc. All rights reserved.
 */
public class LoggingActivity extends RFragment {
    @BindView(R.id.tlbActionBar)
    Toolbar myToolbar;
    @BindView(R.id.txtTitle)
    TextView title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_logging, null);
        ButterKnife.bind(this, view);

        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolbar);

        this.setTitle(this.getString(R.string.title_logging), title);

        return view;
    }

    @OnClick(R.id.btnTraceLog)
    public void sendTraceLog(){
        RevTwo.Trace("Trace Log Message", LoggingActivity.this.getContext());

    }
    @OnClick(R.id.btnDebugLog)
    public void sendDebugLog(){
        RevTwo.Debug("Debug Log Message", LoggingActivity.this.getContext());

    }
    @OnClick(R.id.btnWarningLog)
    public void sendWarningLog(){
        RevTwo.Warn("Warning Log Message", LoggingActivity.this.getContext());
    }
    @OnClick(R.id.btnErrorLog)
    public void sendErrorLog(){
        RevTwo.Error("Error Log Message", LoggingActivity.this.getContext());
    }

}
