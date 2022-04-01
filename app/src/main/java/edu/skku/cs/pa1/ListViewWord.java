package edu.skku.cs.pa1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;

public class ListViewWord extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> items;
    private ArrayList<String> items2;

    public ListViewWord(Context mContext, ArrayList<String> items, ArrayList<String> items2){
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
            view=layoutinflater.inflate(R.layout.listview_word, viewGroup, false);
        }
        TextView tv1=view.findViewById(R.id.textView1);
        TextView tv2=view.findViewById(R.id.textView2);
        TextView tv3=view.findViewById(R.id.textView3);
        TextView tv4=view.findViewById(R.id.textView4);
        TextView tv5=view.findViewById(R.id.textView5);

        String input=items.get(i).toString();
        String answer=items2.get(i).toString();
        String[] split=new String[5];
        String[] ans=new String[5];

        for(int j=0; j<5; j++){
            split[j]=String.valueOf(input.charAt(j));
        }
        for(int k=0; k<5; k++){
            ans[k]=String.valueOf(answer.charAt(k));
        }

        tv1.setText(split[0].toUpperCase());
        tv2.setText(split[1].toUpperCase());
        tv3.setText(split[2].toUpperCase());
        tv4.setText(split[3].toUpperCase());
        tv5.setText(split[4].toUpperCase());

        if(split[0].equals(ans[0])){
            tv1.setBackgroundColor(Color.parseColor("#99F691"));
            tv1.setTextColor(Color.parseColor("#000000"));
        }
        else{
            boolean check=false;
            for(int n=0; n<5; n++){
                if(split[0].equals(ans[n]))
                    check=true;
            }
            if(check==true){
                tv1.setBackgroundColor(Color.parseColor("#FFE46F"));
                tv1.setTextColor(Color.parseColor("#000000"));
            }
            else{
                tv1.setBackgroundColor(Color.parseColor("#787C7E"));
                tv1.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }

        if(split[1].equals(ans[1])){
            tv2.setBackgroundColor(Color.parseColor("#99F691"));
            tv2.setTextColor(Color.parseColor("#000000"));
        }
        else{
            boolean check=false;
            for(int n=0; n<5; n++){
                if(split[1].equals(ans[n]))
                    check=true;
            }
            if(check==true){
                tv2.setBackgroundColor(Color.parseColor("#FFE46F"));
                tv2.setTextColor(Color.parseColor("#000000"));
            }
            else{
                tv2.setBackgroundColor(Color.parseColor("#787C7E"));
                tv2.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }

        if(split[2].equals(ans[2])){
            tv3.setBackgroundColor(Color.parseColor("#99F691"));
            tv3.setTextColor(Color.parseColor("#000000"));
        }
        else{
            boolean check=false;
            for(int n=0; n<5; n++){
                if(split[2].equals(ans[n]))
                    check=true;
            }
            if(check==true){
                tv3.setBackgroundColor(Color.parseColor("#FFE46F"));
                tv3.setTextColor(Color.parseColor("#000000"));
            }
            else{
                tv3.setBackgroundColor(Color.parseColor("#787C7E"));
                tv3.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }

        if(split[3].equals(ans[3])){
            tv4.setBackgroundColor(Color.parseColor("#99F691"));
            tv4.setTextColor(Color.parseColor("#000000"));
        }
        else{
            boolean check=false;
            for(int n=0; n<5; n++){
                if(split[3].equals(ans[n]))
                    check=true;
            }
            if(check==true){
                tv4.setBackgroundColor(Color.parseColor("#FFE46F"));
                tv4.setTextColor(Color.parseColor("#000000"));
            }
            else{
                tv4.setBackgroundColor(Color.parseColor("#787C7E"));
                tv4.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }

        if(split[4].equals(ans[4])){
            tv5.setBackgroundColor(Color.parseColor("#99F691"));
            tv5.setTextColor(Color.parseColor("#000000"));
        }
        else{
            boolean check=false;
            for(int n=0; n<5; n++){
                if(split[4].equals(ans[n]))
                    check=true;
            }
            if(check==true){
                tv5.setBackgroundColor(Color.parseColor("#FFE46F"));
                tv5.setTextColor(Color.parseColor("#000000"));
            }
            else{
                tv5.setBackgroundColor(Color.parseColor("#787C7E"));
                tv5.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }

        return view;
    }
}
