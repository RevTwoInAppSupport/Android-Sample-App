package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
        refreshFileList();
        lstAdapter = new ArrayAdapter<String>(this, R.layout.list_menu_item, R.id.txtMenuItem, fileNames);
        lstAppFiles.setAdapter(lstAdapter);
    }

    private void refreshFileList() {
        fileNames = new ArrayList<String>();
        File dir = getFilesDir();
        for(File f: dir.listFiles()) {
            fileNames.add(f.getName().toString());
        }
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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
