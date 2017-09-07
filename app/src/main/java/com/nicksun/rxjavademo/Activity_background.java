package com.nicksun.rxjavademo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nick on 2017/9/7.
 */

public class Activity_background extends Activity {
    @BindView(R.id.button_act01_start)
    Button bt;
    @BindView(R.id.tv_act01)
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act01);
        ButterKnife.bind(this);

    }
}
