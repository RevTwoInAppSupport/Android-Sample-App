package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


/**
 * Created by Zajim on 10-Feb-16.
 */
public class LoggingActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);
        myToolbar = (Toolbar) findViewById(R.id.tlbActionBar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(this.getString(R.string.title_logging));
    }

    public void onTraceLogClick(View v) {

    }

    public void onDebugLogClick(View v) {

    }

    public void onWarningLogClick(View v) {

    }

    public void onErrorLogClick(View v) {

    }
}
