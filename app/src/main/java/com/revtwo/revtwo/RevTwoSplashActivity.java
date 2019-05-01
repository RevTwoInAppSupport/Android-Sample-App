package com.revtwo.revtwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.revtwo.revtwolib.KBAnswersActivity;
import com.revtwo.revtwolib.RevTwo;
import com.revtwo.revtwolib.models.callback.Callback;
import com.revtwo.revtwolib.models.enumerations.ModeEnum;

/*
 *  RevTwoSplashActivity.java
 *  RevTwo-Sample-App
 *
 *  Created on 4/4/2016.
 *  Copyright (c) 2015-2019 RevTwo, Inc. All rights reserved.
 */
public class RevTwoSplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);

        RevTwo.setDomain("https://beta.revtwo.com/index.php/");
        RevTwo.initialize("665E7568-226E-9EBB-5E41-6AFA9DB9BFD7", "Fx2pmW8SczfXRTgGQL9JDrjbK", ModeEnum.R2MODE_DEVELOPMENT, true, this, new Callback() {
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
