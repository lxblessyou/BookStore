package com.example.user.bookstore.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.example.user.bookstore.R;
import com.example.user.bookstore.activity.MainActivity;
import com.example.user.bookstore.fragment.discover.TabAndroidFragment;
import com.example.user.bookstore.fragment.discover.TabCFragment;
import com.example.user.bookstore.fragment.discover.TabIOSFragment;
import com.example.user.bookstore.fragment.discover.TabJavaFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18/1/10.
 */
public class DiscoverFragment extends Fragment {
    private Context mContext;
    private MainActivity mActivity;
    private PagerSlidingTabStrip tabs;
    private ViewPager vp_discover_tab;
    private List<Fragment> mList = new ArrayList<>();

    public static DiscoverFragment newInstance(int position) {
        DiscoverFragment discoverFragment = new DiscoverFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        discoverFragment.setArguments(args);
        return discoverFragment;
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
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        mList.add(TabJavaFragment.newInstance(0));
        mList.add(TabCFragment.newInstance(1));
        mList.add(TabAndroidFragment.newInstance(2));
        mList.add(TabIOSFragment.newInstance(3));
        // Initialize the ViewPager and set an adapter
        vp_discover_tab = (ViewPager) view.findViewById(R.id.vp_discover_tab);
        vp_discover_tab.setAdapter(new DiscoverPagerTabAdapter(mActivity.getSupportFragmentManager()));

        // Bind the tabs to the ViewPager
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabs.setShouldExpand(true);// 标签宽度可扩展
        tabs.setIndicatorColor(0xFF3F9FE0); // 颜色值区分大小写
        tabs.setViewPager(vp_discover_tab);
        return view;
    }

    private class DiscoverPagerTabAdapter extends FragmentPagerAdapter {
        private String mTitles[] = {"Java","C/OC/C++","Android","IOS"};

        public DiscoverPagerTabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }
    }
}