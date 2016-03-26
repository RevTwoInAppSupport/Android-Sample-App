package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.revtwo.librevtwo.RevTwo;

/**
 * Created by NIHAD on 11.2.2016.
 */
public class SQLiteDatabaseActivity extends BaseActivity {

    private RevTwo revTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database);
        myToolbar = (Toolbar) findViewById(R.id.tlbActionBar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(this.getString(R.string.title_sqlite_db));
        revTwo = new RevTwo(this);
        revTwo.r2RegisterActivityForScreenshot(this);
    }
}
