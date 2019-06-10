package com.example.administrator.new_course;

import android.util.Log;

import com.example.administrator.new_course.mvp.base.BaseMvpPresenter;
import com.example.administrator.new_course.mvp.IMvpView;

public class SplashTimerPrecenter extends BaseMvpPresenter {


    private final SplashActivity mActivity;
    private CustomCountTimer countTimer;


    public SplashTimerPrecenter(SplashActivity activity){
        this.mActivity = activity;
    }

    public void initTimer() {
        countTimer = new CustomCountTimer(5, new CustomCountTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mActivity.setTVTimer(time + "秒");
//                text_view.setText();
            }

            @Override
            public void onFinish() {
                mActivity.setTVTimer("跳过");
//                text_view.setText();
            }
        });
        countTimer.Start();

    }

    public void cancal() {
        countTimer.Cancal();
    }




    @Override
    protected IMvpView getEmptyView() {


        return null;
    }


    @Override
    public void onDestory() {
        super.onDestory();
        cancal();
        Log.e("AAAAAAAA","onDestory");
    }
}
