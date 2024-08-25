package com.example.activities;

import android.os.Bundle;
import android.widget.TextView;

import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity2 extends AppCompatActivity {

    private TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            String name = arguments.get("name").toString();
            String phone = arguments.getString("phone");

            displayTextView = (TextView)findViewById(R.id.text_field);
            displayTextView.setText("Имя: " + name + ", телефон: " + phone);
        }
    }

    public void saveText(View view){
        FileOutputStream fos = null;
        try {
            Bundle arguments = getIntent().getExtras();

            String name = null;
            String phone = null;
            if (arguments != null) {
                name = arguments.get("name").toString();
                phone = arguments.getString("phone");
            }
            String text = "Имя: " + name + ", телефон: " + phone;

            fos = openFileOutput("text.txt", MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }

        catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();}

        finally{
            try{
                if(fos!=null) fos.close();}

            catch(IOException ex){Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();}
        }
    }

    public void loadText(View view){
        FileInputStream fin = null;
        TextView textView = findViewById(R.id.saved_text);

        try {
            fin = openFileInput("text.txt");
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            textView.setText(text);
        }
        catch(IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();}

        finally{
            try{
                if(fin!=null) fin.close();}

            catch(IOException ex){
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();}
        }
    }

}