package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.revtwo.revtwolib.RevTwo;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *  SQLiteDatabaseActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/11/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public class SQLiteDatabaseActivity extends RFragment {

    @BindView(R.id.tlbActionBar)
    Toolbar myToolbar;
    @BindView(R.id.txtTitle)
    TextView title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sqlite_database, null);
        ButterKnife.bind(this,view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        this.setTitle(this.getString(R.string.title_sqlite_db), title);
        return view;
    }


}
