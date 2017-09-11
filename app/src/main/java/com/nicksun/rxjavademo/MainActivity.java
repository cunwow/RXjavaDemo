package com.nicksun.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.rv_main)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        List<String> titles = new ArrayList<>();
        titles.add("(1) 后台执行耗时操作，实时通知 UI 更新");
        titles.add("(2) 计算一段时间内数据的平均值");
        titles.add("(3) 搜索优化");
        titles.add("(4) 使用 Retrofit 加载数据");
        titles.add("(5) 简单及进阶的轮询操作");
        titles.add("(6) 基于错误类型的重试操作");
        titles.add("(7) 基于 combineLatest 实现的输入验证监听");
        titles.add("(8) 如何实现带有缓存的网络请求");
        titles.add("(9) 用 timer/interval/delay 完全替代 TimerTask");
        titles.add("(10) 在屏幕旋转导致 Activity 重建时，保持数据");
        titles.add("(11) 使用 distinctUntilChanged 检测网络状态变化");
        titles.add("(12) Cold & HotObservable 的例子");
        titles.add("(13) 防止异常导致事件流结束");
        titles.add("(14) 获取Token");
        titles.add("(15) 使用Using操作符");
        MainAdapter mainAdapter = new MainAdapter(titles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);
    }


}
