package com.revtwo.revtwo;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.revtwo.librevtwo.RevTwo;

/*
 *  CreateNewTicketActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/10/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public class CreateNewTicketActivity extends AppCompatActivity {
    private EditText ticketDescription;
    private RevTwo revTwo;
    private LinearLayout lnrTexts;
    private TextView txtCancelHelpRequest;
    private TextView txtTicketLabelMessage;
    private Toolbar myToolbar;
    private ImageView imgCloseIcon;
    private LinearLayout lnrBackButton;
    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_ticket);
        myToolbar = (Toolbar) findViewById(R.id.tlbActionBar);
        myToolbar.setBackgroundColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        this.removeDefaultTitle();
        this.showCloseImg();
        this.hideBackButton();
        lnrTexts = (LinearLayout)findViewById(R.id.lnrTexts);
        txtCancelHelpRequest = (TextView)findViewById(R.id.txtCancelHelpRequest);
        txtTicketLabelMessage = (TextView)findViewById(R.id.txtTicketLabelMessage);
        ticketDescription = (EditText) findViewById(R.id.txtTicketDescription);
        imgCloseIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateNewTicketActivity.this.finish();
            }
        });
        revTwo = new RevTwo(this);
        revTwo.r2RegisterActivityForScreenshot(this);
        if(revTwo.r2IsTicketOpen()) {
            lnrTexts.setVisibility(View.VISIBLE);
            this.setTitle(this.getString(R.string.title_you_have_open_help_request));
            txtTicketLabelMessage.setText(revTwo.getLastOpenTicketDescription());
            txtTicketLabelMessage.setVisibility(View.VISIBLE);
            ticketDescription.setText("");
            ticketDescription.setVisibility(View.INVISIBLE);
        } else {
            this.setTitle(this.getString(R.string.title_ask_for_help));
            ticketDescription.setVisibility(View.VISIBLE);
            txtTicketLabelMessage.setVisibility(View.GONE);
        }
        ticketDescription.setFocusableInTouchMode(true);
        ticketDescription.requestFocus();
        ticketDescription.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String description = ticketDescription.getText().toString();
                    revTwo.r2OpenTicket(description, "", "", "", false);
                    CreateNewTicketActivity.this.setTitle(CreateNewTicketActivity.this.getString(R.string.title_you_have_open_help_request));
                    lnrTexts.setVisibility(View.VISIBLE);
                    txtTicketLabelMessage.setText(ticketDescription.getText().toString());
                    txtTicketLabelMessage.setVisibility(View.VISIBLE);
                    ticketDescription.setText("");
                    ticketDescription.setVisibility(View.INVISIBLE);
                    InputMethodManager inputManager = (InputMethodManager) CreateNewTicketActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.toggleSoftInput(0, 0);
                    handled = true;
                }
                return handled;
            }
        });

        txtCancelHelpRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revTwo.r2CloseTicket();
                lnrTexts.setVisibility(View.GONE);
                txtTicketLabelMessage.setVisibility(View.GONE);
                CreateNewTicketActivity.this.setTitle(CreateNewTicketActivity.this.getString(R.string.title_ask_for_help));
                ticketDescription.setVisibility(View.VISIBLE);
            }
        });
    }

    private void removeDefaultTitle() {
        ActionBar ab = getSupportActionBar();
        ab.setTitle("");
    }

    private void hideBackButton() {
        lnrBackButton = (LinearLayout)findViewById(R.id.lnrBackButton);
        lnrBackButton.setVisibility(View.GONE);
    }

    private void showCloseImg() {
        imgCloseIcon = (ImageView) findViewById(R.id.imgCloseIcon);
        imgCloseIcon.setVisibility(View.VISIBLE);
    }

    private void setTitle(String title) {
        txtTitle = (TextView)findViewById(R.id.txtTitle);
        txtTitle.setText(title);
    }
}
