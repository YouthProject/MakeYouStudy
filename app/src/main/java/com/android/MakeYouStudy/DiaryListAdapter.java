package com.android.MakeYouStudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DiaryListAdapter extends BaseAdapter {
    private Context ctx;
    private int layout;
    private ArrayList<Diary> data;
    private LayoutInflater inflater;

    public DiaryListAdapter(Context ctx, int layout, ArrayList<Diary> data) {
        this.ctx = ctx;
        this.layout = layout;
        this.data = data;
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(layout,parent,false);
        }
        TextView textView_code_list = (TextView)convertView.findViewById(R.id.textView_code);
        TextView textView_title_list = (TextView)convertView.findViewById(R.id.textView_title);
        TextView textView_date_list = (TextView)convertView.findViewById(R.id.textView_date);
        textView_code_list.setText(data.get(position).getCode()+"");
        textView_title_list.setText(data.get(position).getTitle()+"");
        textView_date_list.setText(data.get(position).getDate()+"");
        return convertView;
    }
}