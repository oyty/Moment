package com.xelement.moment.ui.dialog;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Datetime: 2018/5/8 15:31
 * Author: zcj
 */
public abstract class BaseAdapter<E, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected Context mContext;
    private List<E> mData = new ArrayList<>();
    private OnItemClickListener<E> mOnItemClickListener;

    public interface OnItemClickListener<E> {
        void onItemClick(View view, int position, E data);
    }

    public void setOnItemClickListener(OnItemClickListener<E> listener) {
        this.mOnItemClickListener = listener;
    }

    public BaseAdapter(Context context, List<E> list) {
        this.mContext = context;
        if (list != null) {
            mData.clear();
            mData.addAll(list);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(getItemViewResId(viewType), parent, false);
        return createVH(view, viewType);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 重写此方法，避免更新单个View时全量刷新导致的闪烁。
     *
     * @param holder
     * @param position
     * @param payloads
     */
    @Override
    public void onBindViewHolder(@NonNull VH holder, int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            updateView(holder, position, payloads);
        }
    }

    protected E getItemData(int position) {
        return mData.get(position);
    }

    /**
     * 修改数据源并刷新。如果数据为发生变化，则界面亦无变化
     *
     * @param data
     */
    public void setDataAndNotify(List<E> data) {
        if (data == null) {
            return;
        }

        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 修改数据源并强制刷新。强制刷新是指会先移除旧数据，然后再添加新数据，无论数据是否发生变化，界面都会有刷新的效果
     *
     * @param data
     */
    public void setDataAndRefresh(List<E> data) {
        if (data == null) {
            return;
        }

        int oldSize = mData.size();
        int newSize = data.size();

        mData.clear();
        notifyItemRangeRemoved(0, oldSize);

        mData.addAll(data);
        notifyItemRangeInserted(0, newSize);
    }

    public List<E> getData() {
        return mData;
    }

    /**
     * 删除指定元素
     *
     * @param position
     */
    public void removeItem(int position) {
        if (position < 0 || position >= mData.size()) {
            return;
        }
        mData.remove(position);
        notifyItemRemoved(position);
        //删除一个元素，同时需要通知adapter更新后续数据，否则出现position错乱。
        notifyItemRangeChanged(position, mData.size() - position);
    }

    public void removeAll() {
        mData.clear();
        notifyDataSetChanged();
    }

    public void addItem(E data) {
        addItem(mData.size(), data);
    }

    /**
     * 在指定位置插入元素
     *
     * @param position
     * @param data
     */
    public void addItem(int position, E data) {
        if (position < 0 || position > mData.size()) {
            return;
        }

        mData.add(position, data);
        notifyItemInserted(position);
        //增加一个元素，同时需要通知adapter更新后续数据，否则出现position错乱。
        notifyItemRangeChanged(position, mData.size() - position);
    }

    public void addAll(List<E> data) {
        if (data == null || data.size() == 0) {
            return;
        }

        int positionStart = data.size();
        mData.addAll(data);
        notifyItemRangeInserted(positionStart, data.size());
        //增加元素，同时需要通知adapter更新后续数据，否则出现position错乱。
        notifyItemRangeChanged(positionStart, mData.size() - positionStart);
    }

    /**
     * 更新指定位置的数据
     *
     * @param position
     * @param data
     * @param obj      如果obj不为空，那么将调用{@link #updateView(RecyclerView.ViewHolder, int, List)}进行单个view的局部刷新
     *                 否则更新整个view会有闪烁的问题
     */
    public void updateItem(int position, E data, @Nullable Object obj) {
        if (position < 0 || position >= mData.size()) {
            return;
        }

        mData.remove(position);
        mData.add(position, data);
        notifyItemChanged(position, obj);
    }

    /**
     * 局部刷新。刷新单个view
     *
     * @param holder
     * @param position
     * @param payloads
     */
    protected void updateView(VH holder, int position, @NonNull List<Object> payloads) {
    }

    protected abstract @LayoutRes
    int getItemViewResId(int viewType);

    protected abstract VH createVH(View view, int viewType);
}
