package com.example.user.bookstore.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by user on 18/1/11.
 */

public class Category extends BmobObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
