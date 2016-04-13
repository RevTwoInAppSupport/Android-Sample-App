package com.revtwo.revtwo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by harisk on 4/12/16.
 */
public class RActivity extends AppCompatActivity {

    public void showNewFragment(Class<? extends RFragment> fragmentClass, Integer whereToPlaceId, boolean addToBackstack){

        String fragmentName = fragmentClass.getSimpleName();

        FragmentManager fm = getSupportFragmentManager();

        boolean isInBackStack;


        isInBackStack = fm.popBackStackImmediate(fragmentName, 0);

        FragmentTransaction fragTM = fm.beginTransaction();

        if(getSupportFragmentManager().getBackStackEntryCount()>0) {
            fragTM.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        }

        if(!isInBackStack) {
            try {
                fragTM.replace(whereToPlaceId, fragmentClass.newInstance(), fragmentName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if(addToBackstack && !isInBackStack) {
            fragTM.addToBackStack(fragmentName);
        }

        //fragTM.setTransition(FragmentTransaction.);
        fragTM.commitAllowingStateLoss();

        fm.executePendingTransactions();

    }
}
