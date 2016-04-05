package com.revtwo.revtwo;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

/**
 * Created by NIHAD on 11.2.2016.
 */
public class BaseFragment extends Fragment {

    private TextView txtTitle;
    private LinearLayout lnrBackButton;
    private ListView lstMenu;
    private Toolbar tlbActionBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.base_fragment, null);
    }

    protected void removeDefaultTitle() {
        ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar();
        ab.setTitle("");
    }

    protected void setTitle(String title, View view) {
        txtTitle = (TextView)view.findViewById(R.id.txtTitle);
        txtTitle.setText(title);
    }

    protected void setOnBackPressed(final View view, final Fragment fragment) {
        lstMenu = (ListView)fragment.getActivity().findViewById(R.id.lstMenu);
        tlbActionBar = (Toolbar)fragment.getActivity().findViewById(R.id.tlbActionBar);
        lnrBackButton = (LinearLayout)view.findViewById(R.id.lnrBackButton);
        lnrBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideToRightMainActivity(lstMenu);
                slideToRightMainActivity(tlbActionBar);
                slideToLeft(view);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
        });
    }

    private void slideToRightMainActivity(View view) {
        TranslateAnimation animate = new TranslateAnimation(-view.getWidth(),0,0,0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.VISIBLE);
    }

    private void slideToLeft(View view) {
        TranslateAnimation animate = new TranslateAnimation(0, view.getWidth(),0,0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.GONE);
    }
}
