package com.example.expense_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    TextView tv1;

    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.et_cat);
        et2 = (EditText)findViewById(R.id.et_price);
        tv1 = (TextView)findViewById(R.id.tv_output);

    }
    public void save(View view)
    {  s1=et1.getText().toString();
        s2="\n"+s1+" "+et2.getText().toString();

        try {
            FileOutputStream fos = openFileOutput("File1.txt",MODE_APPEND);
            fos.write(s2.getBytes());
            et1.setText("");
            et2.setText("");
            Toast.makeText(getApplicationContext(),"Data saved",Toast.LENGTH_LONG).show();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load(View view)
    { try{
        FileInputStream fis = openFileInput("File1.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb= new StringBuilder();
        String text;
        while((text=br.readLine())!=null)
        {
            sb.append(text);
            sb.append("\n");

        }
        tv1.setText(sb.toString());

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    }

}
