package com.example.tp4_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = (Button) findViewById(R.id.start);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i;
                i = new Intent(MainActivity.this, ServiceMusique.class);
                i.putExtra("name","sound");

                startService(i);

            }
        });

        Button pauseButton = (Button) findViewById(R.id.stop);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MainActivity.this, ServiceMusique.class);
                i.putExtra("name","sound");

                stopService(i);
            }
        });



        Button listButton = (Button) findViewById(R.id.list);

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MainActivity.this, MyPlayList.class);
                startActivity(i);
            }
        });


        Button QuitButton = (Button) findViewById(R.id.quit);

        QuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}