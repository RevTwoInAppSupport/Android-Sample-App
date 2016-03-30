package com.revtwo.revtwo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.revtwo.librevtwo.RevTwo;

import java.io.File;
import java.util.ArrayList;
/**
 * Created by NIHAD on 11.2.2016.
 */
public class FileBrowsingActivity extends BaseActivity {
    private ArrayList<String> fileNames;
    private ListView lstAppFiles;
    private ArrayAdapter<String> lstAdapter;
    private TextView emptyListViewText;
    private RevTwo revTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_browsing);
        lstAppFiles = (ListView)findViewById(R.id.lstAppFiles);
        emptyListViewText = (TextView)findViewById(android.R.id.empty);
        lstAppFiles.setEmptyView(emptyListViewText);
        myToolbar = (Toolbar) findViewById(R.id.tlbActionBar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(this.getString(R.string.title_file_browsing));
        revTwo = new RevTwo(this);
        revTwo.r2RegisterActivityForScreenshot(this);
        refreshFileList();
    }

    private void refreshFileList() {
        fileNames = new ArrayList<String>();
        this.getFilesFromStorages(getFilesDir().getParent());
        lstAdapter = new ArrayAdapter<String>(this, R.layout.list_menu_item, R.id.txtMenuItem, fileNames);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_file_browsing_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh_page:
                this.refreshFileList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
