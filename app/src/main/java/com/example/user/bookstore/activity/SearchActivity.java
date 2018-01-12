package com.example.user.bookstore.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.user.bookstore.R;
import com.example.user.bookstore.adapter.BookListAdapter;
import com.example.user.bookstore.bean.BookInfo;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class SearchActivity extends BaseActivity {

    private EditText et_search;
    private LinearLayout ll_loading;
    private ImageView iv_search_btn;
    private ListView lv_search;
    private BookListAdapter mAdapter;
    private List<BookInfo> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        et_search = (EditText) findViewById(R.id.et_search);
        ll_loading = (LinearLayout) findViewById(R.id.ll_loading);
        iv_search_btn = (ImageView) findViewById(R.id.iv_search_btn);
        iv_search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contains = et_search.getText().toString().trim();
                if (!TextUtils.isEmpty(contains)) {
                    searchFromData(contains);
                    et_search.setText("");
                    hideInput();
                } else {
                    toast("请输入搜索内容");
                }
            }
        });
        lv_search = (ListView) findViewById(R.id.lv_search);
        mAdapter = new BookListAdapter(this, mList);
        lv_search.setAdapter(mAdapter);
    }

    private void hideInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(et_search.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private void searchFromData(final String contains) {
        ll_loading.setVisibility(View.VISIBLE);
        BmobQuery<BookInfo> bmobQuery = new BmobQuery<>();
        bmobQuery.findObjects(new FindListener<BookInfo>() {
            @Override
            public void done(List<BookInfo> list, BmobException e) {
                if (e == null) {
                    mList.clear();
                    for (BookInfo bookInfo : list) {
                        if (bookInfo.getTitle().contains(contains)) {
                            mList.add(bookInfo);
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                } else {
                    e.printStackTrace();
                }
                ll_loading.setVisibility(View.GONE);
            }
        });
    }
}
