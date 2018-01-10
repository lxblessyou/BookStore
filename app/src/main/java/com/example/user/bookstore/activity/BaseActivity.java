package com.example.user.bookstore.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.bookstore.R;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private List<Activity> mActivities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1.隐藏ActionBar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_base);
        // 2.添加Activity到集合中
        mActivities.add(this);
    }

    /**
     * 结束所有Activity
     */
    public void finishAll() {
        int size = mActivities.size();
        for (int i = 0; i < size; i++) {
            mActivities.remove(i);
            finish();
        }
    }
}
