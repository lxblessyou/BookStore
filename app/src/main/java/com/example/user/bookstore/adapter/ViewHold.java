package com.example.user.bookstore.adapter;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by user on 18/1/12.
 */

public class ViewHold {
    public static <T extends View> T getView(View view, int id) {
        SparseArray<View> sparseArray = (SparseArray<View>) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            view.setTag(sparseArray);
        }
        T t = (T) sparseArray.get(id);
        if (t == null) {
            t = view.findViewById(id);
            sparseArray.put(id,t);
        }
        return t;
    }
}
