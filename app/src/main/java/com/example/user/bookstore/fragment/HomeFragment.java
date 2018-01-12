package com.example.user.bookstore.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.bookstore.R;
import com.example.user.bookstore.activity.MainActivity;
import com.example.user.bookstore.adapter.BookListAdapter;
import com.example.user.bookstore.bean.BookInfo;
import com.panxw.android.imageindicator.AutoPlayManager;
import com.panxw.android.imageindicator.ImageIndicatorView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by user on 18/1/10.
 */

public class HomeFragment extends Fragment {
    private Context mContext;
    private MainActivity mActivity;

    private ImageIndicatorView imageIndicatorView;

    private ListView lv_home;
    private BookListAdapter mAdapter;
    private List<BookInfo> mList = new ArrayList<>();

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
        //addBookInfo();
        //初始化View
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //初始化Android-image-indicator
        initBanner(view);
        //初始化列表
        lv_home = view.findViewById(R.id.lv_home);
        mAdapter = new BookListAdapter(mContext, mList);
        lv_home.setAdapter(mAdapter);
        //获取数据
        getBookInfo();
        return view;
    }

    private void getBookInfo() {
        BmobQuery<BookInfo> bmobQuery = new BmobQuery<BookInfo>();
        bmobQuery.findObjects(new FindListener<BookInfo>() {
            @Override
            public void done(List<BookInfo> list, BmobException e) {
                if (e == null) {
//                    toast("获取成功");
                    mList.clear();
                    mList.addAll(list);
                    //mList = list; //列表数据源并未改变
                    if (mAdapter != null) {
                        mAdapter.notifyDataSetChanged();
                    }
                } else {
                    toast("获取失败");
//                    Log.i(TAG, "done: "+e);
                }
            }
        });
    }

    private void toast(String text) {
        Toast.makeText(mActivity, text, Toast.LENGTH_SHORT).show();
    }

    private void initBanner(View view) {
        imageIndicatorView = (ImageIndicatorView) view.findViewById(R.id.indicate_view);
        final Integer[] resArray = new Integer[]{R.mipmap.qdzt, R.mipmap.qinghuabiancheng, R.mipmap.scala};
        imageIndicatorView.setupLayoutByDrawable(resArray);
        imageIndicatorView.setIndicateStyle(ImageIndicatorView.INDICATE_USERGUIDE_STYLE);
        imageIndicatorView.show();
        AutoPlayManager autoBrocastManager = new AutoPlayManager(imageIndicatorView);
        autoBrocastManager.setBroadcastEnable(true);
        autoBrocastManager.setBroadCastTimes(5);//loop times
        autoBrocastManager.setBroadcastTimeIntevel(3 * 1000, 3 * 1000);//set first play time and interval
        autoBrocastManager.loop();
    }

    private void addBookInfo() {
        BookInfo p2 = new BookInfo();
        p2.setAuthor("author");
        p2.setCategory_id("");
        p2.setContent_des("content_des");
        p2.setDiscount(6);
        p2.setDiscount_price(66);
        p2.setFolio("16");
        p2.setLetters(888888);
        p2.setPages(666);
        p2.setPrice(88);
        p2.setPublishing_company("publishing_company");
        p2.setPublishing_date("2018-01-01");
        p2.setRevision(1);
        p2.setTitle("title");
        p2.setStar(5);
        p2.setTotal(666);
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    toast("添加数据成功，返回objectId为：" + objectId);
                } else {
                    toast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }
}
