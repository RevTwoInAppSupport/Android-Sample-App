package com.revtwo.revtwo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.revtwo.revtwo.adapters.MainMenuAdapter;
import com.revtwo.revtwo.enums.MenuEnum;
import com.revtwo.revtwo.models.MenuItem;
import com.revtwo.revtwolib.CommunityActivity;
import com.revtwo.revtwolib.CommunityTicketActivityLaunchOptions;
import com.revtwo.revtwolib.KBAnswersActivity;
import com.revtwo.revtwolib.MyTicketActivity;
import com.revtwo.revtwolib.MyTicketActivityLaunchOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *  DemoListFragment.java
 *  RevTwo-Sample-App
 *
 *  Created on 4/12/2016.
 *  Copyright (c) 2015-2019 RevTwo, Inc. All rights reserved.
 */
public class DemoListFragment extends RFragment {

    @BindView(R.id.fragment_demo_list)
    ListView list;
    private ArrayList<MenuItem> menuItems;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_list,container,false);
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
        menuItems.add(new MenuItem(MenuEnum.FAQ_VIEW.getValue(),this.getString(R.string.menu_title_faq_view)));

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
                MyTicketActivityLaunchOptions options = new MyTicketActivityLaunchOptions.Builder()
                        .setTagBackButton("Tutorials")
                        .setTags(new String[] {"yellow", "blue"})
                        .build();

                MyTicketActivity.open(getActivity(), options);
            }
            else if(viewId == MenuEnum.COMMUNITY_VIEW.getValue()){
                CommunityTicketActivityLaunchOptions options = new CommunityTicketActivityLaunchOptions.Builder()
                        .setTagBackButton("Tutorials")
                        .setTags(new String[]{"yellow"})
                        .build();

                CommunityActivity.open(getActivity(), options);
            }
            else if(viewId == MenuEnum.FAQ_VIEW.getValue()){
                //Intent faqIntent = new Intent(getActivity(),KBAnswersActivity.class);
                //startActivity(faqIntent);
                KBAnswersActivity.open(getActivity(),true);
            }

        }

    }
}
