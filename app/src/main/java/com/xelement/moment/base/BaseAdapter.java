package com.xelement.moment.base;

import android.content.Context;

import java.util.List;

/**
 * 所有Adapter的base类
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    protected Context mContext;
    private List<T> mLists;
    protected String key;

    private BaseAdapter(Context context) {
        this.mContext = context;
    }

    public BaseAdapter(Context context, List<T> lists) {
        this.mContext = context;
        this.mLists = lists;
    }

    @Override
    public int getCount() {
        if (mLists == null)
            return -1;
        return mLists.size();
    }

    @Override
    public T getItem(int position) {
        if (mLists == null || mLists.size() <= 0 || position < 0 || position >= mLists.size())
            return null;
        return mLists.get(position);
    }

    public T getPositionItem(int position) {
        return mLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setDataAndNotify(List<T> lists) {
        this.mLists = lists;
        notifyDataSetChanged();
        this.key = "";
    }

    public void setDataAndNotify(List<T> lists, String key) {
        this.mLists = lists;
        notifyDataSetChanged();
        this.key = key;
    }

    public int getListSize() {
        return mLists.size();
    }

    public List<T> getList() {
        return mLists;
    }

}
