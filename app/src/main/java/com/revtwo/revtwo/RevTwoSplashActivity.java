package com.revtwo.revtwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.revtwo.revtwolib.RevTwo;
import com.revtwo.revtwolibmodels.callback.Callback;
import com.revtwo.revtwolibmodels.enumerations.ModeEnum;

/*
 *  RevTwoSplashActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 4/4/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public class RevTwoSplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);

        RevTwo.initialize("ADD YOUR KEY HERE", "ADD YOUR PRIVATE KEY HERE", ModeEnum.R2MODE_DEVELOPMENT, true, this, new Callback() {
            @Override
            public void onSuccess(Object param) {
                super.onSuccess(param);
                startMainActivity();
                finish();
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                // Error handling
            }
        });

    }

    private void startMainActivity() {
        Intent i = new Intent(RevTwoSplashActivity.this, MainActivity.class);
        startActivity(i);
    }
}
