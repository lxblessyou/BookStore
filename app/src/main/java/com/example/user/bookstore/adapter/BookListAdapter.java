package com.example.user.bookstore.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.bookstore.R;
import com.example.user.bookstore.bean.BookInfo;

import java.util.List;

/**
 * Created by user on 18/1/11.
 */

public class BookListAdapter extends BaseAdapter {
    private Context context;
    private List<BookInfo> list;
    private LayoutInflater inflater;

    public BookListAdapter(Context context, List<BookInfo> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_book, parent, false);
        }
        ImageView iv_book = ViewHold.getView(convertView, R.id.iv_book);
        TextView tv_title = ViewHold.getView(convertView, R.id.tv_title);
        TextView tv_price = ViewHold.getView(convertView, R.id.tv_price);
        TextView tv_star = ViewHold.getView(convertView, R.id.tv_star);
        TextView tv_discount = ViewHold.getView(convertView, R.id.tv_discount);
        TextView tv_discount_price = ViewHold.getView(convertView, R.id.tv_discount_price);

        BookInfo bookInfo = (BookInfo) getItem(position);
        Glide.with(convertView).load(bookInfo.getImage_url()).into(iv_book);
        tv_title.setText(bookInfo.getTitle());
        tv_star.setText(bookInfo.getStar() + "星");
        tv_price.setText("￥" + bookInfo.getPrice());
        tv_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv_discount.setText(bookInfo.getDiscount() + "折");
        tv_discount_price.setText("￥" + bookInfo.getDiscount_price());
        return convertView;
    }
}
