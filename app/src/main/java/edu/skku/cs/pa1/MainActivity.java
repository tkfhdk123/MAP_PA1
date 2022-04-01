package edu.skku.cs.pa1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ListView listview_w;
    private ListView listview_gray;
    private ListView listview_yellow;
    private ListView listview_green;
    private ListViewWord listviewword;
    private ArrayList<String> items;
    private ArrayList<String> items2;
    private ArrayList<String> gray;
    private ArrayList<String> yellow;
    private ArrayList<String> green;
    private String answer;
    private int num;
    private int retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num=0;
        retry=0;
        String[] dict=new String[6000];
        items=new ArrayList<>();
        items2=new ArrayList<>();
        gray=new ArrayList<>();
        yellow=new ArrayList<>();
        green=new ArrayList<>();

        try {
            InputStream is=getApplicationContext().getAssets().open("wordle_words.txt");
            BufferedReader rd=new BufferedReader(new InputStreamReader(is));
            while((dict[num]=rd.readLine()) != null){
                num+=1;
            }
            int rand=(int)(Math.random() * (num-1));
            answer=dict[rand];

        } catch (IOException e) {
            e.printStackTrace();
        }

        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(view -> {
            EditText editText=(EditText)findViewById(R.id.edittext);
            String input=editText.getText().toString();
            input=input.toLowerCase();
            btn.setText(answer);

            boolean check=false;
            for(int i=0; i<num; i++){
                if(input.equals(dict[i])){
                    check=true;
                    break;
                }
            }
            if(check==false){
                Toast.makeText(getApplicationContext(), "Word '" + input + "' not in dictionary!", Toast.LENGTH_SHORT).show();
            }
            else{
                listview_w=findViewById(R.id.lv_word);
                items.add(input);
                items2.add(answer);
                listviewword=new ListViewWord(MainActivity.this, items, items2);
                listview_w.setAdapter(listviewword);

                String[] parse_input=new String[5];
                String[] parse_answer=new String[5];
                for(int n=0; n<5; n++){
                    parse_input[n]=String.valueOf(input.charAt(n));
                }
                for(int m=0; m<5; m++){
                    parse_answer[m]=String.valueOf(answer.charAt(m));
                }

                for(int l=0; l<5; l++){
                    if(parse_input[l].equals(parse_answer[l])){
                        if(yellow.contains(parse_input[l]))
                            yellow.remove(parse_input[l]);
                        if(green.contains(parse_input[l])==false)
                            green.add(parse_input[l]);
                    }
                    else{
                        boolean wd_in=false;
                        for(int o=0; o<5; o++){
                            if(parse_input[l].equals(parse_answer[o]))
                                wd_in=true;
                        }
                        if(wd_in==false)
                            if(gray.contains(parse_input[l])==false)
                                gray.add(parse_input[l]);
                        else
                            if(green.contains(parse_input[l])==false)
                                if(yellow.contains(parse_input[l])==false)
                                    yellow.add(parse_input[l]);
                    }
                }

            }
        });
    }
}