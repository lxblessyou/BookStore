package com.example.user.bookstore.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.bookstore.R;

/**
 * Created by user on 18/1/10.
 */
public class DiscoverFragment extends Fragment {

    public static DiscoverFragment newInstance(int position) {
        DiscoverFragment discoverFragment = new DiscoverFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        discoverFragment.setArguments(args);
        return discoverFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        return view;
    }
}