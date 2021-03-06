package com.revtwo.revtwo;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 *  FileBrowsingActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/11/2016.
 *  Copyright (c) 2015-2019 RevTwo, Inc. All rights reserved.
 */
public class FileBrowsingActivity extends RFragment {
    private ArrayList<String> fileNames;
    private String [] excludedFiles = new String[]{"revtwo","revtwo-journal"};
    ArrayAdapter<String> lstAdapter;

    @BindView(R.id.lstAppFiles)
    ListView lstAppFiles;
    @BindView(android.R.id.empty)
    TextView emptyListViewText;
    @BindView(R.id.tlbActionBar)
    Toolbar myToolbar;
    @BindView(R.id.txtThirdButton)
    TextView txtThirdButton;
    @BindView(R.id.txtTitle)
    TextView title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_file_browsing,null);
        ButterKnife.bind(this, view);
        lstAppFiles.setEmptyView(emptyListViewText);
        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolbar);
        this.setTitle(this.getString(R.string.title_file_browsing), title);
        this.showThirdButton("refresh");
        refreshFileList();

        return view;
    }

    @OnClick(R.id.txtThirdButton)
    public void onRefresh(){
        refreshFileList();
    }

    protected void showThirdButton(String text) {
        txtThirdButton.setText(text);
        txtThirdButton.setVisibility(View.VISIBLE);
    }

    private void refreshFileList() {
        fileNames = new ArrayList<String>();
        this.getFilesFromStorages(getActivity().getFilesDir().getParent());
        lstAdapter = new ArrayAdapter<String>(this.getContext(), R.layout.list_menu_item, R.id.txtMenuItem, fileNames);
        lstAppFiles.setAdapter(lstAdapter);
    }

    private void getFilesFromStorages(String path) {
        File file = new File(path);
        String[] parentList = file.list();
        if(parentList != null) {
            for(File f: file.listFiles()) {
                if(f.isDirectory()) {
                    this.getFilesFromStorages(f.getAbsolutePath());
                } else if (shouldIncludeFile(f.getName())) {
                    fileNames.add(getPath(f.getAbsolutePath()));
                }
            }
        }
    }


    private String getPath(String fullPath){
        return fullPath.split(getActivity().getPackageName()+"/")[1];
    }

    private boolean shouldIncludeFile(String filename){
        return !Arrays.asList(excludedFiles).contains(filename);
    }


}
