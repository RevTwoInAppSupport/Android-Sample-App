package com.revtwo.revtwo.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.revtwo.revtwo.R;
import com.revtwo.revtwo.models.MenuItemMainActivity;

import java.util.List;

/**
 * Created by Zajim on 13-Feb-16.
 */
public class MenuMainActivityAdapter extends ArrayAdapter {

    private Context context;
    private List<MenuItemMainActivity> items;
    private @LayoutRes int resource;

    public MenuMainActivityAdapter(Context context, @LayoutRes int resource, List<MenuItemMainActivity> items) {
        super(context, resource, R.id.rltMenuListItemMainActivity, items.toArray());
        this.context = context;
        this.items = items;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View menuListItem = convertView;
        MenuItemMainActivity item = this.items.get(position);
        MenuViewHolder menuViewHolder = null;
        if (menuListItem == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            menuListItem = inflater.inflate(this.resource, parent, false);
            menuViewHolder = new MenuViewHolder(menuListItem);
            menuListItem.setTag(menuViewHolder);
        } else {
            menuViewHolder = (MenuViewHolder) menuListItem.getTag();
        }
        menuViewHolder.getTxtMenuTitle().setText(item.getTitle());
        menuListItem.setId(item.getId());
        return menuListItem;
    }

    private class MenuViewHolder {
        private TextView txtMenuTitle;

        public MenuViewHolder(View view) {
            txtMenuTitle = (TextView) view.findViewById(R.id.txtMenuItemMainActivity);
        }

        public TextView getTxtMenuTitle() {
            return txtMenuTitle;
        }
    }
}
