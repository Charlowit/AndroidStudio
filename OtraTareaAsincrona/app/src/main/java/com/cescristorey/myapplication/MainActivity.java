package com.cescristorey.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.cescristorey.myapplication.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textview1);

        TareaAsincrona tarea = new TareaAsincrona();
        tarea.execute();


    }
    public class TareaAsincrona extends AsyncTask<Void, Void, String> {

        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(Void... v){
            String jugador = "";
            String jugadores = "";
            int posicion = 0;
            int posicionFinal = 0;
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            URL api = NetworkUtils.buildUrl();
            String githubSearchResults = null;
            try {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(api);
                while(posicion < githubSearchResults.length()) {
                    posicion = githubSearchResults.indexOf("apodo");
                    System.out.println(posicion);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            text.setText(s);
        }

    }
}
