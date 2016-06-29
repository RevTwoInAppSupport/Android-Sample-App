package com.revtwo.revtwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.revtwo.librevtwo.CreateTicketActivity;
import com.revtwo.librevtwo.R2CommunityActivity;
import com.revtwo.revtwo.adapters.MainMenuAdapter;
import com.revtwo.revtwo.enums.MenuEnum;
import com.revtwo.revtwo.models.MenuItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 *  DemoListFragment.java
 *  RevTwo-Sample-App
 *
 *  Created on 4/12/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
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
        menuItems.add(new MenuItem(MenuEnum.MY_TICKET_VIEW.getValue(), this.getString(R.string.menu_title_my_ticket_view)));
        menuItems.add(new MenuItem(MenuEnum.COMMUNITY_VIEW.getValue(), this.getString(R.string.menu_title_community_view)));


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
            else if(viewId == MenuEnum.MY_TICKET_VIEW.getValue()) {
                Intent createNewTicketFragment = new Intent(getActivity(), CreateTicketActivity.class);
                startActivity(createNewTicketFragment);
            }
            else if(viewId == MenuEnum.COMMUNITY_VIEW.getValue()){
                Intent community = new Intent(getActivity(), R2CommunityActivity.class);
                startActivity(community);

            }

        }
    }
}
