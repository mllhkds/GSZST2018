package com.example.a13466.gsst.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a13466.gsst.R;
import com.example.a13466.gsst.been.Drawer;

import java.util.List;

public class MenuListAdapter extends BaseAdapter {
    private List<Drawer> mlist;
    private LayoutInflater inflater;

    public MenuListAdapter(Context context,List<Drawer> mlist) {
        this.mlist = mlist;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Drawer getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview,null);
            holder = new ViewHolder();
            holder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Drawer drawer = getItem(position);
        if (drawer !=null) {
            holder.content.setText(drawer.getmTextView());
        }
        return convertView;
    }

    class ViewHolder{
        TextView content;
    }
}
