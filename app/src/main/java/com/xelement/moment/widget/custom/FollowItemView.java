package com.xelement.moment.widget.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.xelement.moment.R;

import butterknife.ButterKnife;

/**
 * Created by oyty on 2019/1/12.
 */
public class FollowItemView extends FrameLayout {

    private final Context mContext;

    public FollowItemView(@NonNull Context context) {
        this(context, null);
    }

    public FollowItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FollowItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_follow_item, this);
        ButterKnife.bind(this, view);
    }
}
