package com.student.gsd.gsdstudentapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.student.gsd.gsdstudentapp.R;

/**
 * Created by dreamfire on 25.05.16.
 */
public class NavDrawerAdapter extends BaseAdapter {
    private String[] mItemMenu;
    private Context mContext;

    public NavDrawerAdapter(Context _c, String[] _list){
        mContext = _c;
        mItemMenu = _list;
    }

    @Override
    public int getCount() {
        return mItemMenu.length;
    }

    @Override
    public Object getItem(int position) {
        return mItemMenu[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_list_item, null);
        }
        TextView tvItem = (TextView) convertView.findViewById(R.id.tvTitleItem);
        tvItem.setText(mItemMenu[position]);

        return convertView;
    }
}
