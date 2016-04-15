package com.revtwo.revtwo;

import android.os.Bundle;;
import android.support.v7.widget.Toolbar;

import com.revtwo.librevtwo.R2ModeEnum;
import com.revtwo.librevtwo.RevTwo;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends RActivity {

    private RevTwo revTwo;


    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_new);
    ButterKnife.bind(this);

    revTwo = new RevTwo(this);
    revTwo.r2Intialize("253B1C2A-34FB-A08A-3981-4B3D87728C9B", "3qQJsrLpNnWvCbD6PcKHztS5d", R2ModeEnum.R2MODE_DEVELOPMENT.getValue());
    /*revTwo.r2CustomizeIncomingCallText("Nihad Ahmetovic calling");
        revTwo.r2CustomizeIncomingCallBackgroundColor("#CDCDCD");
        revTwo.r2CustomizeIncomingCallTextColor("#EEEEEE");
        revTwo.r2CustomizeIncomingCallImage(R.drawable.rev_two_splash_screen);*/
        revTwo.r2RegisterActivityForScreenshot(this);

    showDemoListFragment();

}

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }

    public void showFragment(Class<? extends RFragment> fragmentClass){
         showNewFragment(fragmentClass,R.id.activity_main_new_container,true);
     }

    public void showDemoListFragment(){
         showFragment(DemoListFragment.class);
    }


}
