package com.example.administrator.new_course;

import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.new_course.base.BaseActivity;
import com.example.administrator.new_course.base.ViewInject;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {


    @BindView(R.id.fac_main_home)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.rg_tabs_1)
    RadioGroup radioGroup_1;

//    @BindView(R.id.rg_tabs_2)
//    RadioGroup radioGroup_2;

    @BindView(R.id.rb_mine)
    RadioButton rb_mine;

    @BindView(R.id.rb_yours)
    RadioButton rb_yours;

//    @BindView(R.id.rb_his)
//    RadioButton rb_his;
//
//    @BindView(R.id.rb_hers)
//    RadioButton rb_hers;

    @BindView(R.id.fl_main_bottom_menu)
    FrameLayout fl_mine_bottom_menu;

    private boolean isChangeTopOrBottom;
    RadioGroup rg_tabs1;
    RadioGroup rg_tabs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        changeAnima(radioGroup_2,radioGroup_1);

        rg_tabs1 = findViewById(R.id.rg_tabs_1);
        rg_tabs2 = findViewById(R.id.rg_tabs_2);
        changeAnima(rg_tabs2, rg_tabs1);
//        initHomeFragment();

    }

//    //初始化  Fragment
//    private void initHomeFragment() {
//
//
//    }


    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fac_main_home:


                isChangeTopOrBottom = !isChangeTopOrBottom;

                if (isChangeTopOrBottom) {
                    changeAnima(rg_tabs1, rg_tabs2);
                } else {
                    changeAnima(rg_tabs2, rg_tabs1);
                }
                break;
        }


    }

    private void changeAnima(RadioGroup gone, RadioGroup show) {

        //消失的动画
        gone.clearAnimation();

        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);

        gone.startAnimation(animationGone);

        gone.setVisibility(View.GONE);


        //展示的动画
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);

        show.startAnimation(animationShow);
        show.setVisibility(View.GONE);
    }
}
