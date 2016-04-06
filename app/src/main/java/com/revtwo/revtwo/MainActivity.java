package com.revtwo.revtwo;

import android.content.Intent;
import android.os.Bundle;;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.revtwo.librevtwo.RevTwo;
import com.revtwo.revtwo.adapters.MenuMainActivityAdapter;
import com.revtwo.revtwo.enums.MenuEnum;
import com.revtwo.revtwo.models.MenuItemMainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lstMenu;
    private ArrayAdapter<String> lstAdapter;
    private List<MenuItemMainActivity> menuItems;
    private RevTwo revTwo;
    private Toolbar tlbActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstMenu = (ListView)findViewById(R.id.lstMenu);
        loadMenuItems();
        tlbActionBar = (Toolbar) findViewById(R.id.tlbActionBar);
        lstAdapter = new MenuMainActivityAdapter(this, R.layout.list_menu_item_main_activity, menuItems);
        lstMenu.setAdapter(lstAdapter);
        lstMenu.setOnItemClickListener(new OnMenuItemClick());
        revTwo = new RevTwo(this);
        revTwo.r2Intialize("253B1C2A-34FB-A08A-3981-4B3D87728C9B", "3qQJsrLpNnWvCbD6PcKHztS5d", 0);
        /*revTwo.r2CustomizeIncomingCallText("zajim kujovic");
        revTwo.r2CustomizeIncomingCallBackgroundColor("#CDCDCD");
        revTwo.r2CustomizeIncomingCallTextColor("#EEEEEE");
        revTwo.r2CustomizeIncomingCallImage(R.drawable.rev_two_splash_screen);*/
        revTwo.r2RegisterActivityForScreenshot(this);
    }

    private void loadMenuItems(){
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItemMainActivity(MenuEnum.LOGGING.getValue(), this.getString(R.string.menu_title_logging)));
        menuItems.add(new MenuItemMainActivity(MenuEnum.FILE_BROWSING.getValue(), this.getString(R.string.menu_title_file_browsing)));
        menuItems.add(new MenuItemMainActivity(MenuEnum.SQLITE_DATABASE.getValue(), this.getString(R.string.menu_title_sqlite_database)));
        menuItems.add(new MenuItemMainActivity(MenuEnum.CREATE_NEW_TICKET.getValue(), this.getString(R.string.menu_title_create_new_ticket)));
    }

    public int getFragmentCommit(Fragment fragment) {
        return getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
                .replace(R.id.frgmList, fragment,
                        fragment.getClass().getName()).commit();
    }

    private class OnMenuItemClick implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int viewId = view.getId();
            Fragment fragment = null;
            if(viewId == MenuEnum.LOGGING.getValue()) {
                fragment = new LoggingActivity();
            }
            else if(viewId == MenuEnum.FILE_BROWSING.getValue()) {
                fragment = new FileBrowsingActivity();
            }
            else if(viewId == MenuEnum.SQLITE_DATABASE.getValue()) {
                fragment = new SQLiteDatabaseActivity();
            }
            else if(viewId == MenuEnum.CREATE_NEW_TICKET.getValue()) {
                Intent createNewTicketFragment = new Intent(MainActivity.this, CreateNewTicketActivity.class);
                startActivity(createNewTicketFragment);
            }
            if (fragment != null) {
                slideToLeft(tlbActionBar);
                slideToLeft(lstMenu);
                getFragmentCommit(fragment);
            }
        }
    }

    private void slideToLeft(View view){
        TranslateAnimation animate = new TranslateAnimation(0,-view.getWidth(),0,0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.INVISIBLE);
    }
}
