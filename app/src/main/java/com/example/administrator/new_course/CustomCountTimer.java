package com.example.administrator.new_course;

import android.os.Handler;

public class CustomCountTimer implements Runnable {


    private final ICountDownHandler iCountDownHandler;
    private int mTime;
    private int countDownTime;
    private final Handler handler;
    private boolean isRun;

    public CustomCountTimer(int time, ICountDownHandler iCountDownHandler) {
        handler = new Handler();
        this.mTime = time;
        this.countDownTime = mTime;
        this.iCountDownHandler = iCountDownHandler;

    }

    /**
     * 实现具体逻辑
     */
    @Override
    public void run() {
        if (isRun) {
            if (iCountDownHandler != null) {
                iCountDownHandler.onTicker(countDownTime);
            }
            if (countDownTime == 0) {
                Cancal();
                if (iCountDownHandler != null) {
                    iCountDownHandler.onFinish();
                }
            } else {
                countDownTime = mTime--;
                handler.postDelayed(this, 1000);
            }
        }
    }


    public void Start() {
        isRun = true;
        handler.post(this);
    }

    public void Cancal() {
        isRun = false;
        handler.removeCallbacks(this);
    }


    public interface ICountDownHandler {
        //倒计时回调
        void onTicker(int time);

        //完成回调
        void onFinish();
    }


}
