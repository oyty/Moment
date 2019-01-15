package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.xelement.moment.R;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.ui.activity.MomentDetailActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class FresherView extends FrameLayout {

    private final Context mContext;
    private ProductEntity entity;

    public FresherView(@NonNull Context context) {
        this(context, null);
    }

    public FresherView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FresherView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_fresher, this);
        ButterKnife.bind(this, view);
    }

    public void refresh(ProductEntity entity) {
        this.entity = entity;
    }

    @OnClick(R.id.mBaseAction)
    public void onViewClicked() {
        Intent intent = new Intent(mContext, MomentDetailActivity.class);
        intent.putExtra(Constants.DETAIL_DATA, entity);
        intent.putExtra(Constants.IS_FRESH, true);
        mContext.startActivity(intent);
    }
}
