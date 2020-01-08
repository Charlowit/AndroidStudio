package com.cescristorey.xilofono;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void presionDO(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.note1);
        mp.start();
    }
    public void presionRE(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.note2);
        mp.start();
    }
    public void presionMI(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.note3);
        mp.start();
    }
    public void presionFA(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.note4);
        mp.start();
    }
    public void presionSOL(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.note5);
        mp.start();
    }
    public void presionLA(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.note6);
        mp.start();
    }
    public void presionSI(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.note7);
        mp.start();
    }
}
