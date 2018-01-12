package com.example.user.bookstore.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.user.bookstore.R;
import com.example.user.bookstore.fragment.DiscoverFragment;
import com.example.user.bookstore.fragment.HomeFragment;
import com.example.user.bookstore.fragment.PersonalFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_tab_personal;
    private Button btn_tab_discover;
    private Button btn_tab_home;
    private ViewPager vp_home;
    private MyPagerAdapter mAdapter;
    private List<Fragment> mFragmentList;
    private int mCurrentPosition;

    private long firstBackTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1.初始化数据
        initData();
        // 2.初始化View
        initView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - firstBackTime <= 1000) {
                finishAll();
            } else {
                toast("再次点击退出应用");
                firstBackTime = currentTimeMillis;
            }
        }
        return true;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mFragmentList = new ArrayList<>();
        HomeFragment homeFragment = HomeFragment.newInstance(0);
        DiscoverFragment discoverFragment = DiscoverFragment.newInstance(1);
        PersonalFragment personalFragment = PersonalFragment.newInstance(2);
        mFragmentList.add(homeFragment);
        mFragmentList.add(discoverFragment);
        mFragmentList.add(personalFragment);
    }

    /**
     * 初始化View
     */
    private void initView() {
        btn_tab_home = (Button) findViewById(R.id.btn_tab_home);
        btn_tab_discover = (Button) findViewById(R.id.btn_tab_discover);
        btn_tab_personal = (Button) findViewById(R.id.btn_tab_personal);
        // tab按钮单击事件
        btn_tab_home.setOnClickListener(this);
        btn_tab_discover.setOnClickListener(this);
        btn_tab_personal.setOnClickListener(this);
        // 显示ViewPager
        vp_home = (ViewPager) findViewById(R.id.vp_home);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(), mFragmentList);
        vp_home.setAdapter(mAdapter);
        vp_home.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 记录当前页面位置
                mCurrentPosition = position;
                // 改变tab状态，同步tab标签和ViewPager
                switch (position) {
                    case 0:
                        homeSelected();
                        break;
                    case 1:
                        discoverSelected();
                        break;
                    case 2:
                        personalSelected();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // 默认选中主页
        homeSelected();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tab_home:
                homeSelected();
                mCurrentPosition = 0;
                break;
            case R.id.btn_tab_discover:
                discoverSelected();
                mCurrentPosition = 1;
                break;
            case R.id.btn_tab_personal:
                personalSelected();
                mCurrentPosition = 2;
                break;
            default:
                break;
        }
        // 同步tab标签和ViewPager
        vp_home.setCurrentItem(mCurrentPosition);
    }

    private void personalSelected() {
        btn_tab_home.setSelected(false);
        btn_tab_discover.setSelected(false);
        btn_tab_personal.setSelected(true);
    }

    private void discoverSelected() {
        btn_tab_home.setSelected(false);
        btn_tab_discover.setSelected(true);
        btn_tab_personal.setSelected(false);
    }

    private void homeSelected() {
        btn_tab_home.setSelected(true);
        btn_tab_discover.setSelected(false);
        btn_tab_personal.setSelected(false);
    }

    /**
     * FragmentPager适配器类
     */
    class MyPagerAdapter extends FragmentPagerAdapter {
        private FragmentManager mFm;
        private List<Fragment> mList;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mFm = fm;
            this.mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }
}
