package com.example.user.bookstore.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.bookstore.R;
import com.example.user.bookstore.activity.MainActivity;
import com.panxw.android.imageindicator.AutoPlayManager;
import com.panxw.android.imageindicator.ImageIndicatorView;

/**
 * Created by user on 18/1/10.
 */

public class HomeFragment extends Fragment {
    private Context mContext;
    private MainActivity mActivity;

    private ImageIndicatorView imageIndicatorView;

    public static HomeFragment newInstance(int position) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        this.mActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // 初始化Android-image-indicator
        initBanner(view);
        return view;
    }

    private void initBanner(View view) {
        imageIndicatorView = (ImageIndicatorView) view.findViewById(R.id.indicate_view);
        // 1.显示轮播
        final Integer[] resArray = new Integer[]{R.mipmap.qdzt, R.mipmap.qinghuabiancheng, R.mipmap.scala};
        imageIndicatorView.setupLayoutByDrawable(resArray);
        imageIndicatorView.setIndicateStyle(ImageIndicatorView.INDICATE_USERGUIDE_STYLE);
        imageIndicatorView.show();
        // 2.自动轮播
        AutoPlayManager autoBrocastManager = new AutoPlayManager(imageIndicatorView);
        autoBrocastManager.setBroadcastEnable(true);
//        autoBrocastManager.setBroadCastTimes(5);//loop times
        autoBrocastManager.setBroadcastTimeIntevel(0, 3 * 1000);//set first play time and interval
        autoBrocastManager.loop();
    }
}
