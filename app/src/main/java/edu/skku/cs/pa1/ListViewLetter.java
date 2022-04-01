package edu.skku.cs.pa1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewLetter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> items;
    private ArrayList<String> items2;

    public ListViewLetter(Context mContext, ArrayList<String> items, ArrayList<String> items2){
        this.mContext=mContext;
        this.items=items;
        this.items2=items2;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater layoutinflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutinflater.inflate(R.layout.listview_letter, viewGroup, false);
        }
        TextView tv_lt=view.findViewById(R.id.textview_lt);

        String text=items.get(i).toString();
        tv_lt.setText(text.toUpperCase());

        String color=items2.get(i).toString();
        if(color.equals("green")){
            tv_lt.setBackgroundColor(Color.parseColor("#99F691"));
            tv_lt.setTextColor(Color.parseColor("#000000"));
        }
        else if(color.equals("yellow")){
            tv_lt.setBackgroundColor(Color.parseColor("#FFE46F"));
            tv_lt.setTextColor(Color.parseColor("#000000"));
        }
        else if(color.equals("gray")){
            tv_lt.setBackgroundColor(Color.parseColor("#787C7E"));
            tv_lt.setTextColor(Color.parseColor("#FFFFFF"));
        }

        return view;
    }
}
