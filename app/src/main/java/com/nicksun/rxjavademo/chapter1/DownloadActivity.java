package com.nicksun.rxjavademo.chapter1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nicksun.rxjavademo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by nick on 2017/9/7.
 */

public class DownloadActivity extends Activity {
    @BindView(R.id.button_download)
    Button bt;
    @BindView(R.id.tv_background)
    TextView tv;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private static String TAG = "DownloadActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);
        ButterKnife.bind(this);

    }
    //点击开始下载,空间响应方法
    public void startDownload(View view){
       //创建被观察者
       final Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
           @Override
           public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
               for (int i = 0; i < 100; i++){
                   if (i % 20 == 0){
                       try {
                           Thread.sleep(500);
                       } catch (InterruptedException e1) {
                           if (!e.isDisposed()){
                               e.onError(e1);//如果出现错误,并且事件还没有处理,触发onError
                           }
                       }
                       e.onNext(i);  //模拟延时,触发OnNext,传入进度
                   }
               }
               e.onComplete();//循环结束,下载结束,触发onComplete

           }
       });

        //创建观察者
        DisposableObserver<Integer> disposableObserver = new DisposableObserver<Integer>() {
            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d(TAG, "onNext: "+integer);
                tv.setText("正在下载："+integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: "+e);
                tv.setText("下载失败："+e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
                tv.setText("下载完成!");

            }
        };
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(disposableObserver);
        mCompositeDisposable.add(disposableObserver);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
