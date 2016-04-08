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
import java.util.ArrayList;
/**
 * Created by NIHAD on 11.2.2016.
 */
public class FileBrowsingActivity extends BaseFragment {
    private ArrayList<String> fileNames;
    private ListView lstAppFiles;
    private ArrayAdapter<String> lstAdapter;
    private TextView emptyListViewText;
    private View mainView;
    private Toolbar myToolbar;
    private TextView txtThirdButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.activity_file_browsing, null);
        lstAppFiles = (ListView)mainView.findViewById(R.id.lstAppFiles);
        emptyListViewText = (TextView)mainView.findViewById(android.R.id.empty);
        lstAppFiles.setEmptyView(emptyListViewText);
        myToolbar = (Toolbar) mainView.findViewById(R.id.tlbActionBar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolbar);
        this.showThirdButton("refresh");
        txtThirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshFileList();
            }
        });

        this.removeDefaultTitle();
        this.setTitle(this.getString(R.string.title_file_browsing), mainView);
        this.setOnBackPressed(mainView, FileBrowsingActivity.this);
        new RevTwo(this.getContext()).r2RegisterActivityForScreenshot(this.getActivity());
        refreshFileList();
        return mainView;
    }

    protected void showThirdButton(String text) {
        txtThirdButton = (TextView)mainView.findViewById(R.id.txtThirdButton);
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
                } else {
                    String parent = getParentDir(f);
                    fileNames.add(f.getName().toString());
                }
            }
        }
    }

    private String getParentDir(File f) {
        String parent = f.getParent();
        String[] parentSplit = parent.split("/");
        return parentSplit[parentSplit.length - 1];
    }
}
