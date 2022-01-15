package com.example.tp4_player;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceMusique extends Service {
    MediaPlayer player;



    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Créé", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onDestroy() {
        player.stop();
        Toast.makeText(this, "Service détruit", Toast.LENGTH_LONG).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String music_name=intent.getStringExtra("name");
        player = MediaPlayer.create(this,getResources().getIdentifier(music_name,"raw",getPackageName()));

        Toast.makeText(this, "Service démmaré", Toast.LENGTH_LONG).show();
        player.start();
        return START_STICKY;

    }

}