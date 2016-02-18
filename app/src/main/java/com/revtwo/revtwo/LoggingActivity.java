package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.revtwo.librevtwo.RevTwo;


/**
 * Created by Zajim on 10-Feb-16.
 */
public class LoggingActivity extends BaseActivity {
    private RevTwo revTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging);
        myToolbar = (Toolbar) findViewById(R.id.tlbActionBar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(this.getString(R.string.title_logging));
        revTwo = new RevTwo(this);
    }

    public void onTraceLogClick(View v) {
        revTwo.r2Trace("Trace Log Message");
    }

    public void onDebugLogClick(View v) {
        revTwo.r2Debug("Debug Log Message");
    }

    public void onWarningLogClick(View v) {
        revTwo.r2Warn("Warning Log Message");
    }

    public void onErrorLogClick(View v) {
        revTwo.r2Error("Error Log Message");
    }
}
