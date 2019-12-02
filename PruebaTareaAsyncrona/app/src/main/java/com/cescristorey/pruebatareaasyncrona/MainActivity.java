package com.cescristorey.pruebatareaasyncrona;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.net.URL;

import com.cescristorey.pruebatareaasyncrona.utilities.NetworkUtils;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView1);
        enviar = (Button) findViewById(R.id.enviar1);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TareaAsincrona tarea = new TareaAsincrona();
                tarea.execute();
            }
        });

    }

    public class TareaAsincrona extends AsyncTask<Void, Void, String> {

        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(Void... v){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            URL api = NetworkUtils.buildUrl();
            String githubSearchResults = null;
            try {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(api);
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