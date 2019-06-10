package com.example.administrator.new_course;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ViewInject annotatin = this.getClass().getAnnotation(ViewInject.class);

        if (annotatin != null) {

            int mainLayoutId = annotatin.mainLayoutid();

            if (mainLayoutId > 0) {

                setContentView(mainLayoutId);
                ButterKnife.bind(this);
                bindView();

            } else {
                throw new RuntimeException("mainLayoutId < 0");
            }

        } else {
            throw new RuntimeException("annotatin = null");
        }

    }


    private void bindView(){
        ButterKnife.bind(this);
    }
}
