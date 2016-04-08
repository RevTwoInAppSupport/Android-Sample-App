package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.revtwo.librevtwo.RevTwo;

/**
 * Created by NIHAD on 11.2.2016.
 */
public class SQLiteDatabaseActivity extends BaseFragment {

    private View mainView;
    private Toolbar myToolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.activity_sqlite_database, null);
        myToolbar = (Toolbar) mainView.findViewById(R.id.tlbActionBar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolbar);

        this.removeDefaultTitle();
        this.setTitle(this.getString(R.string.title_sqlite_db), mainView);
        this.setOnBackPressed(mainView, SQLiteDatabaseActivity.this);
        new RevTwo(this.getContext()).r2RegisterActivityForScreenshot(this.getActivity());
        return mainView;
    }
}
