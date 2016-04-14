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

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by NIHAD on 11.2.2016.
 */
public class SQLiteDatabaseActivity extends RFragment {

    @Bind(R.id.tlbActionBar)
    Toolbar myToolbar;
    @Bind(R.id.txtTitle)
    TextView title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sqlite_database, null);
        ButterKnife.bind(this,view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        this.setTitle(this.getString(R.string.title_sqlite_db), title);
        new RevTwo(this.getContext()).r2RegisterActivityForScreenshot(this.getActivity());
        return view;
    }


}
