package com.example.aplikasi_pemutarmusik;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    Button playpause, stop;
    MediaPlayer mp;
    boolean play = true;
    private GifDrawable gifDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        GifImageView gifImageView = findViewById(R.id.gifImageView);

        playpause = (Button)findViewById(R.id.idPlay);

        gifDrawable = (GifDrawable) gifImageView.getDrawable();
        gifDrawable.stop();
        stop = (Button)findViewById(R.id.idStop);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.memories_song);


        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play == true){
                    mp.start();
                    playpause.setText("Pause");
                    play = false;
                    gifDrawable.start();
                }else {
                    mp.pause();

                    playpause.setText("Play");
                    play = true;
                    gifDrawable.stop();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mp.stop();
                    play = true;
                    mp.prepare();
                    mp.seekTo(0);
                    playpause.setText("play");
                    gifDrawable.stop();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
        });
    }
}