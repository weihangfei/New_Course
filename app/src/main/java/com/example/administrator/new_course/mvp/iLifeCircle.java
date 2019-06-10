package com.example.administrator.new_course.mvp;

import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.new_course.mvp.IMvpView;

public interface iLifeCircle {

    void onCreate(Bundle savedInstanceState, Intent intent,Bundle getArguments);

    void onActivityCreated(Bundle savedInstanceState, Intent intent,Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestory();

    void destroyView();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode,Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attavhView(IMvpView iMvpView);
}
