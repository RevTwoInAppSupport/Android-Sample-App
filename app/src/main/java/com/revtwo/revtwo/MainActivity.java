package com.revtwo.revtwo;

import android.content.Intent;
import android.os.Bundle;;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstMenu = (ListView)findViewById(R.id.lstMenu);
        loadMenuItems();
        lstAdapter = new MenuMainActivityAdapter(this, R.layout.list_menu_item_main_activity, menuItems);
        lstMenu.setAdapter(lstAdapter);
        lstMenu.setOnItemClickListener(new OnMenuItemClick());
        new RevTwo(this).r2Intialize("253B1C2A-34FB-A08A-3981-4B3D87728C9B", "3qQJsrLpNnWvCbD6PcKHztS5d", 0);
    }

    private void loadMenuItems(){
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItemMainActivity(MenuEnum.LOGGING.getValue(), this.getString(R.string.menu_title_logging)));
        menuItems.add(new MenuItemMainActivity(MenuEnum.FILE_BROWSING.getValue(), this.getString(R.string.menu_title_file_browsing)));
        menuItems.add(new MenuItemMainActivity(MenuEnum.SQLITE_DATABASE.getValue(), this.getString(R.string.menu_title_sqlite_database)));
        menuItems.add(new MenuItemMainActivity(MenuEnum.CREATE_NEW_TICKET.getValue(), this.getString(R.string.menu_title_create_new_ticket)));
    }

    private class OnMenuItemClick implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int viewId = view.getId();
            if(viewId == MenuEnum.LOGGING.getValue()) {
                Intent loggingFragment = new Intent(MainActivity.this, LoggingActivity.class);
                startActivity(loggingFragment);
            }
            else if(viewId == MenuEnum.FILE_BROWSING.getValue()) {
                Intent createNewTicketFragment = new Intent(MainActivity.this, FileBrowsingActivity.class);
                startActivity(createNewTicketFragment);
            }
            else if(viewId == MenuEnum.SQLITE_DATABASE.getValue()) {
                Intent createNewTicketFragment = new Intent(MainActivity.this, SQLiteDatabaseActivity.class);
                startActivity(createNewTicketFragment);
            }
            else if(viewId == MenuEnum.CREATE_NEW_TICKET.getValue()) {
                Intent createNewTicketFragment = new Intent(MainActivity.this, CreateNewTicketActivity.class);
                startActivity(createNewTicketFragment);
            }

        }
    }
}
