package edu.skku.cs.pa1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListViewLetter extends BaseAdapter {
    private Context mContext;
    private String items;

    public ListViewLetter(Context mContext, String items){
        this.mContext=mContext;
        this.items=items;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
