package com.revtwo.revtwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.revtwo.revtwo.adapters.MainMenuAdapter;
import com.revtwo.revtwo.enums.MenuEnum;
import com.revtwo.revtwo.models.MenuItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by harisk on 4/12/16.
 */
public class DemoListFragment extends RFragment {

    @Bind(R.id.fragment_demo_list)
    ListView list;
    private ArrayList<MenuItem> menuItems;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_list,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         loadMenuItems();
    }

    private void loadMenuItems(){
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(MenuEnum.LOGGING.getValue(), this.getString(R.string.menu_title_logging)));
        menuItems.add(new MenuItem(MenuEnum.FILE_BROWSING.getValue(), this.getString(R.string.menu_title_file_browsing)));
        menuItems.add(new MenuItem(MenuEnum.SQLITE_DATABASE.getValue(), this.getString(R.string.menu_title_sqlite_database)));
        menuItems.add(new MenuItem(MenuEnum.CREATE_NEW_TICKET.getValue(), this.getString(R.string.menu_title_create_new_ticket)));

        list.setAdapter(new MainMenuAdapter(getActivity(), R.layout.list_menu_item_main_activity, menuItems));
        list.setOnItemClickListener(new OnMenuItemClick());
    }

    private class OnMenuItemClick implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int viewId = view.getId();
            if(viewId == MenuEnum.LOGGING.getValue()) {
                ((MainActivity)getActivity()).showFragment(LoggingActivity.class);
            }
            else if(viewId == MenuEnum.FILE_BROWSING.getValue()) {
                ((MainActivity)getActivity()).showFragment(FileBrowsingActivity.class);
            }
            else if(viewId == MenuEnum.SQLITE_DATABASE.getValue()) {
                ((MainActivity)getActivity()).showFragment(SQLiteDatabaseActivity.class);
            }
            else if(viewId == MenuEnum.CREATE_NEW_TICKET.getValue()) {
                Intent createNewTicketFragment = new Intent(getActivity(), CreateNewTicketActivity.class);
                startActivity(createNewTicketFragment);
            }

        }
    }
}