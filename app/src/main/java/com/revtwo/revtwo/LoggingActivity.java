package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.revtwo.librevtwo.RevTwo;


/**
 * Created by Zajim on 10-Feb-16.
 */
public class LoggingActivity extends BaseFragment {
    private RevTwo revTwo;
    private Toolbar myToolbar;
    private View mainView;
    private Button btnTraceLog;
    private Button btnDebugLog;
    private Button btnWarningLog;
    private Button btnErrorLog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.activity_logging, null);
        myToolbar = (Toolbar) mainView.findViewById(R.id.tlbActionBar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolbar);

        this.removeDefaultTitle();
        this.setTitle(this.getString(R.string.title_logging), mainView);
        this.setOnBackPressed(mainView, LoggingActivity.this);

        btnTraceLog = (Button)mainView.findViewById(R.id.btnTraceLog);
        btnDebugLog = (Button)mainView.findViewById(R.id.btnDebugLog);
        btnWarningLog = (Button)mainView.findViewById(R.id.btnWarningLog);
        btnErrorLog = (Button)mainView.findViewById(R.id.btnErrorLog);

        revTwo = new RevTwo(this.getContext());

        btnTraceLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revTwo.r2Trace("Trace Log Message");
            }
        });
        btnDebugLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revTwo.r2Debug("Debug Log Message");
            }
        });
        btnWarningLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revTwo.r2Warn("Warning Log Message");
            }
        });
        btnErrorLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revTwo.r2Error("Error Log Message");
            }
        });

        return mainView;
    }
}
