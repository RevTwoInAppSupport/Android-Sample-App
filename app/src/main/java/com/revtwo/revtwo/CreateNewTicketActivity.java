package com.revtwo.revtwo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.revtwo.librevtwo.RevTwo;

/**
 * Created by NIHAD on 10.2.2016.
 */
public class CreateNewTicketActivity extends BaseActivity {
    private EditText ticketDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_ticket);
        myToolbar = (Toolbar) findViewById(R.id.tlbActionBar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(this.getString(R.string.title_create_new_ticket));
        ticketDescription = (EditText) findViewById(R.id.txtTicketDescription);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create_new_ticket_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_new_ticket:
                TelephonyManager tMgr = (TelephonyManager)CreateNewTicketActivity.this.getSystemService(Context.TELEPHONY_SERVICE);
                String phoneNumber = tMgr.getLine1Number();
                String description = ticketDescription.getText().toString();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
