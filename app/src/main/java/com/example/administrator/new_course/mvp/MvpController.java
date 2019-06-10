package com.example.administrator.new_course.mvp;

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MvpController implements iLifeCircle{


    //存放的是 P层的实例
    private Set<iLifeCircle> iLifeCircles = new HashSet<>();

  public void savePresenter(iLifeCircle iLifeCircle){
      this.iLifeCircles.add(iLifeCircle);
  }



    @Override
    public void onCreate(Bundle savedInstanceState, Intent intent, Bundle getArguments) {

        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

            while (iterator.hasNext()){
                iLifeCircle next = iterator.next();
                if (intent == null){
                    intent = new Intent();

                }
                if (getArguments == null){
                    getArguments = new Bundle();
                }

                next.onCreate(savedInstanceState,intent,getArguments);
            }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments) {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();

            }
            if (getArguments == null){
                getArguments = new Bundle();
            }

            next.onActivityCreated(savedInstanceState,intent,getArguments);
        }
    }

    @Override
    public void onStart() {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            next.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            next.onResume();
        }
    }

    @Override
    public void onPause() {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            next.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            next.onStop();
        }
    }

    @Override
    public void onDestory() {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            next.onDestory();
        }
    }

    @Override
    public void destroyView() {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            next.destroyView();
        }
    }


    @Override
    public void onViewDestroy() {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            next.onViewDestroy();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            if (intent == null){
                intent = new Intent();
            }
            next.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();

            next.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();
            if (bundle == null){
                bundle = new Bundle();
            }
            next.onSaveInstanceState(bundle);
        }
    }

    @Override
    public void attavhView(IMvpView iMvpView) {
        Iterator<iLifeCircle> iterator = this.iLifeCircles.iterator();

        while (iterator.hasNext()){
            iLifeCircle next = iterator.next();

            next.attavhView(iMvpView);
        }
    }
}
