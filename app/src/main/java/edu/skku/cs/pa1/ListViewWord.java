package edu.skku.cs.pa1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ListViewWord extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> items;

    public ListViewWord(Context mContext, ArrayList<String> items){
        this.mContext=mContext;
        this.items=items;
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
            view=layoutinflater.inflate(R.layout.listview_word, viewGroup, false);
        }
        else{

        }
        TextView tv1=view.findViewById(R.id.textView1);
        TextView tv2=view.findViewById(R.id.textView2);
        TextView tv3=view.findViewById(R.id.textView3);
        TextView tv4=view.findViewById(R.id.textView4);
        TextView tv5=view.findViewById(R.id.textView5);

        tv1.setText(items.get(i).toString());
        tv2.setText(items.get(i).toString());
        tv3.setText(items.get(i).toString());
        tv4.setText(items.get(i).toString());
        tv5.setText(items.get(i).toString());

        return view;
    }
}
