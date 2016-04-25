package com.revtwo.revtwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/*
 *  RevTwoSplashActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 4/4/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public class RevTwoSplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private void startMainActivity() {
        Intent i = new Intent(RevTwoSplashActivity.this, MainActivity.class);
        startActivity(i);
    }
}
