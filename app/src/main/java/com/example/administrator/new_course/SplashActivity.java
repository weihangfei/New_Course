package com.example.administrator.new_course;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


import java.io.File;


public class SplashActivity extends BaseActivity {

    private FullScreenVideoView videoView;


    private TextView text_view;


//    private FullScreenVideoView videoView;
//    private TextView text_view;

    private SplashTimerPrecenter splashTimerPre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initListener();

        initVideo();

        initTimerPrecenter();

//        videoView = findViewById(R.id.video_view);
//        text_view = findViewById(R.id.text_view);

    }

    private void initTimerPrecenter() {
        splashTimerPre = new SplashTimerPrecenter(this);
        splashTimerPre.initTimer();
    }


    private void initVideo() {

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    private void initListener() {
        text_view = findViewById(R.id.text_view);
        text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        videoView = findViewById(R.id.video_view);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        splashTimerPre.onDestory();
////        splashTimerPre.cancal();
////        countTimer.Cancal();
//    }

    public void setTVTimer(String tvTimer) {

        text_view.setText(tvTimer);
    }
}
