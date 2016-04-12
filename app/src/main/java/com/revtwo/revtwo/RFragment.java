package com.revtwo.revtwo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import butterknife.OnClick;

/**
 * Created by harisk on 4/12/16.
 */
public class RFragment extends Fragment {

    protected void setTitle(String title, TextView titleView) {
        titleView.setText(title);
    }

    @Nullable
    @OnClick(R.id.lnrBackButton)
    public void onBack(){
        ((MainActivity)getActivity()).onBackPressed();
    }

}
