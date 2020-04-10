package com.revtwo.revtwo;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *  SQLiteDatabaseActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/11/2016.
 *  Copyright (c) 2015-2019 RevTwo, Inc. All rights reserved.
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
        title.setText("Db browser");
        return view;
    }


}
