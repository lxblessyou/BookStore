package com.example.user.bookstore.fragment.discover;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.bookstore.R;
import com.example.user.bookstore.activity.MainActivity;
import com.example.user.bookstore.activity.SearchActivity;
import com.example.user.bookstore.adapter.BookListAdapter;
import com.example.user.bookstore.bean.BookInfo;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by user on 18/1/12.
 */

public class BaseTabFragment extends Fragment {
    private Context mContext;
    private MainActivity mActivity;

    private LinearLayout ll_search;
    private ListView lv_category;
    private BookListAdapter mAdapter;
    private List<BookInfo> mList = new ArrayList<>();

    private String mWheres[] = {"K3Uw444F", "TB3xHHHY", "Y4i7lllU", "21fn333D"};
    private int mCurrentArg;

    public static BaseTabFragment newInstance(int position) {
        BaseTabFragment baseTabFragment = new BaseTabFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        baseTabFragment.setArguments(args);
        return baseTabFragment;
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
        // 1.获取当前Fragment参数
        getFragmentArg();
        // 1.初始化View
        View view = initView(inflater, container);
        // 2.获取网络数据
        getDatas();
        return view;
    }

    @NonNull
    private View initView(LayoutInflater inflater, @Nullable ViewGroup container) {
        // 1.填充布局
        View view = inflater.inflate(R.layout.fragment_discover_tab, container, false);
        // 2.列表
        lv_category = view.findViewById(R.id.lv_category);
        mAdapter =new BookListAdapter(mContext,mList);
        lv_category.setAdapter(mAdapter);
        // 3.搜索框
        ll_search = view.findViewById(R.id.ll_search);
        ll_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity,SearchActivity.class));
            }
        });
        return view;
    }

    private void getFragmentArg() {
        Bundle arguments = getArguments();
        mCurrentArg = arguments.getInt("position");
    }

    private void getDatas() {
        BmobQuery<BookInfo> bmobQuery = new BmobQuery<BookInfo>();
        bmobQuery.addWhereEqualTo("category_id",mWheres[mCurrentArg]);
        bmobQuery.findObjects(new FindListener<BookInfo>() {
            @Override
            public void done(List<BookInfo> list, BmobException e) {
                if (e == null) {
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
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }
}
