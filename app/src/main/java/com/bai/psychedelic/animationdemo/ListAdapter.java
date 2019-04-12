package com.bai.psychedelic.animationdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class ListAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mData;
    public ListAdapter(Context mContext,List<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item,parent,false);
            holder = new ViewHolder();
            holder.mTextView = convertView.findViewById(R.id.text_item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.mTextView.setText(mData.get(position));

        return convertView;
    }

    static class ViewHolder{
        TextView mTextView;
    }
}
