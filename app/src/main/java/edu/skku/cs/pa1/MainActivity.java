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

public class MainActivity extends AppCompatActivity {
    private ListView listview1;
    private ListViewWord listviewword;
    private ArrayList<String> items;
    private ArrayList<String> items2;
    public String answer;
    public int num;
    public int retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num=0;
        retry=0;
        String[] dict=new String[6000];
        items=new ArrayList<>();
        items2=new ArrayList<>();

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
            btn.setText(answer);

            if(input.equals(answer)){

            }
            else{
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
                    listview1=findViewById(R.id.lv_word);
                    items.add(input);
                    items2.add(answer);
                    listviewword=new ListViewWord(MainActivity.this, items, items2);
                    listview1.setAdapter(listviewword);
                }
            }

        });

    }
}