package com.nicksun.rxjavademo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nicksun.rxjavademo.chapter1.DownloadActivity;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

/**
 * Created by nick on 2017/9/8.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{

    private List<String> mTitles = new ArrayList<>();

    public MainAdapter(List<String> titles) {
        this.mTitles = titles;
    }



    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_item, parent, false);
        return new MainViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final MainViewHolder holder, final int position) {
        final String title = mTitles.get(position);
        TextView titleView = holder.mTvTitle;
        titleView.setText(title);
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positon = holder.getAdapterPosition();
                switch (position){
                    case 0:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    //TODO  今日进行到这里 2017/9/11/13:57
                    case 1:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 2:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 3:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 4:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 5:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 6:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 7:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 8:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 9:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 10:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 11:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 12:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 13:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;
                    case 14:
                        Utils.startActivity(view.getContext(), DownloadActivity.class);
                        break;

                }
            }
        });
    }


    @Override
    public int getItemCount() {

        return mTitles.size();
    }


    public static class MainViewHolder extends RecyclerView.ViewHolder{

        public TextView mTvTitle;

        public MainViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView)itemView.findViewById(R.id.tv_title);
        }
    }

}
