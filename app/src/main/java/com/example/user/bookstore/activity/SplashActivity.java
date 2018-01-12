package com.example.user.bookstore.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.user.bookstore.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏ActionBar
        getSupportActionBar().hide();
        //设置全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        //设置无标题
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
              startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },1000);
    }
}
