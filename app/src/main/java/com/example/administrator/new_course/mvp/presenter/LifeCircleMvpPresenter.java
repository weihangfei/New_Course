package com.example.administrator.new_course.mvp.presenter;

import com.example.administrator.new_course.mvp.IMvpView;
import com.example.administrator.new_course.mvp.MvpController;
import com.example.administrator.new_course.mvp.iLifeCircle;

import java.lang.ref.WeakReference;

public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements iLifeCircle {


    protected WeakReference<T> weakReference;

    protected LifeCircleMvpPresenter() {
        super();
    }


    public LifeCircleMvpPresenter(IMvpView iMvpView) {

        super();

        attavhView(iMvpView);

        MvpController mvpController = iMvpView.getMvpController();
        mvpController.savePresenter(this);
    }

    @Override
    public void attavhView(IMvpView iMvpView) {
        if (weakReference == null) {
            weakReference = new WeakReference(iMvpView);
        } else {
            T view = (T) weakReference.get();

            if (view != iMvpView) {
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestory() {
        weakReference = null;

    }


    protected T getView() {
        T view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            return getEmptyView();
        } else {
            return view;

        }
    }

    protected abstract T getEmptyView();

}
