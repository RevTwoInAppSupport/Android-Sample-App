package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.revtwo.librevtwo.RevTwo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by NIHAD on 11.2.2016.
 */
public class FileBrowsingActivity extends RFragment {
    private ArrayList<String> fileNames;
    private String [] excludedFiles = new String[]{"revtwo","revtwo-journal"};
    ArrayAdapter<String> lstAdapter;

    @Bind(R.id.lstAppFiles)
    ListView lstAppFiles;
    @Bind(android.R.id.empty)
    TextView emptyListViewText;
    @Bind(R.id.tlbActionBar)
    Toolbar myToolbar;
    @Bind(R.id.txtThirdButton)
    TextView txtThirdButton;
    @Bind(R.id.txtTitle)
    TextView title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_file_browsing, container,false);
        ButterKnife.bind(this, view);
        lstAppFiles.setEmptyView(emptyListViewText);
        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolbar);
        this.setTitle(this.getString(R.string.title_file_browsing), title);
        new RevTwo(this.getContext()).r2RegisterActivityForScreenshot(this.getActivity());
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
