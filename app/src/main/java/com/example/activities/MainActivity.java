package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v) {

        EditText nameText = findViewById(R.id.name_field);
        EditText phoneText = findViewById(R.id.phone_field);

        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("name", name);
        intent.putExtra("phone", phone);
        startActivity(intent);
    }
}