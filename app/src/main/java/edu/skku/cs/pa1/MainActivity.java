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
    private ListViewLetter listviewletter_gray;
    private ListViewLetter listviewletter_yellow;
    private ListViewLetter listviewletter_green;
    private ArrayList<String> items;
    private ArrayList<String> items2;
    private ArrayList<String> gray;
    private ArrayList<String> gray2;
    private ArrayList<String> yellow;
    private ArrayList<String> yellow2;
    private ArrayList<String> green;
    private ArrayList<String> green2;
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
        gray2=new ArrayList<>();
        yellow=new ArrayList<>();
        yellow2=new ArrayList<>();
        green=new ArrayList<>();
        green2=new ArrayList<>();

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
                editText.setText("");
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
                        if(yellow.contains(parse_input[l])) {
                            yellow.remove(parse_input[l]);
                        }
                        if(green.contains(parse_input[l]) == false) {
                            green.add(parse_input[l]);
                        }
                    }
                    else{
                        if(answer.contains(parse_input[l])) {
                            if (green.contains(parse_input[l]) == false) {
                                if (yellow.contains(parse_input[l]) == false) {
                                    yellow.add(parse_input[l]);
                                }
                            }
                        }
                        else {
                            if (gray.contains(parse_input[l]) == false) {
                                gray.add(parse_input[l]);
                            }
                        }
                    }
                }

                listview_gray=findViewById(R.id.lv_letter_gray);
                listview_yellow=findViewById(R.id.lv_letter_yellow);
                listview_green=findViewById(R.id.lv_letter_green);

                for(int x=0; x<gray.size(); x++){
                    gray2.add("gray");
                }
                for(int y=0; y<yellow.size(); y++){
                    yellow2.add("yellow");
                }
                for(int z=0; z<green.size(); z++){
                    green2.add("green");
                }

                listviewletter_gray=new ListViewLetter(MainActivity.this, gray, gray2);
                listviewletter_yellow=new ListViewLetter(MainActivity.this, yellow, yellow2);
                listviewletter_green=new ListViewLetter(MainActivity.this, green, green2);

                listview_gray.setAdapter(listviewletter_gray);
                listview_yellow.setAdapter(listviewletter_yellow);
                listview_green.setAdapter(listviewletter_green);
            }
        });
    }
}