package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.xelement.moment.R;
import com.xelement.moment.ui.activity.MomentDetailActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class DiscoveryHotView extends FrameLayout {

    private final Context mContext;

    public DiscoveryHotView(@NonNull Context context) {
        this(context, null);
    }

    public DiscoveryHotView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiscoveryHotView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_discovery_hot, this);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.mBaseAction)
    public void baseAction() {
        Intent intent = new Intent(mContext, MomentDetailActivity.class);
    }
}
