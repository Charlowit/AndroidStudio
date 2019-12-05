package com.cescristorey.appmovie;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pelicula_Actividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);
        Intent intent = getIntent();
        String message = intent.getStringExtra("titulo");
        String vote = intent.getStringExtra("puntuacion");
        TextView textView1 = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        textView1.setText(message);
        textView2.setText(vote);
    }
}
