package com.example.administrator.new_course;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.io.File;


public class SplashActivity extends AppCompatActivity {

    private FullScreenVideoView videoView;
    private TextView text_view;
    private CustomCountTimer countTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        videoView = findViewById(R.id.video_view);
        text_view = findViewById(R.id.text_view);
        text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });


        countTimer = new CustomCountTimer(5, new CustomCountTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                text_view.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                text_view.setText("跳过");
            }
        });
        countTimer.Start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countTimer.Cancal();
    }
}
