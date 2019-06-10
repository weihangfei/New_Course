package com.example.administrator.new_course;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


@ViewInject(mainLayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {


    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;
    @BindView(R.id.rb_mine)
    RadioButton rbMine;
    @BindView(R.id.rb_yours)
    RadioButton rbYours;
    @BindView(R.id.rg_tabs_1)
    RadioGroup rgTabs1;
    @BindView(R.id.rb_his)
    RadioButton rbHis;
    @BindView(R.id.rb_hers)
    RadioButton rbHers;
    @BindView(R.id.rg_tabs_2)
    RadioGroup rgTabs2;
    @BindView(R.id.fl_main_bottom_menu)
    FrameLayout flMainBottomMenu;


    private boolean isChangeTabs1OrTabs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        changeAnima(rgTabs2,rgTabs1);
    }


    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fac_main_home:
                isChangeTabs1OrTabs2 = !isChangeTabs1OrTabs2;
                if (isChangeTabs1OrTabs2) {
                    changeAnima(rgTabs1,rgTabs2);
                }else{
                    changeAnima(rgTabs2,rgTabs1);
                }
                break;
        }


    }


    private void changeAnima(RadioGroup gone, RadioGroup show) {

        //消失的动画
        gone.clearAnimation();//清除动画

        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);

        gone.startAnimation(animationGone);

        gone.setVisibility(View.GONE);


        //展示的动画
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);

        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

}
