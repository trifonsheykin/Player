package com.example.trifonsheykin.player;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

public class PlayActivity extends AppCompatActivity {
    String dataSource;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mediaPlayer = new MediaPlayer();

        Intent intent = getIntent();
        dataSource = intent.getStringExtra("data");
        mediaPlayer.reset();

        try {
            mediaPlayer.setDataSource(dataSource);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

            mediaPlayer.prepare();



        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();


    }
}
