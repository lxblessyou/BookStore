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
public class PersonalFragment extends Fragment {

    public static PersonalFragment newInstance(int position) {
        PersonalFragment personalFragment = new PersonalFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        personalFragment.setArguments(args);
        return personalFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        return view;
    }
}
