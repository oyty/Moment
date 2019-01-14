package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.xelement.moment.R;
import com.xelement.moment.util.UIUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2018/10/13.
 */
public class OrderTypeView extends FrameLayout {

    private int rowLabel;
    private int rowIcon;
    private Context mContext;

    @BindView(R.id.mTypeImg)
    ImageView mTypeImg;
    @BindView(R.id.mTypeLabel)
    TextView mTypeLabel;
    @BindView(R.id.mMsgView)
    BadgeView mMsgView;

    public OrderTypeView(@NonNull Context context) {
        this(context, null);
    }

    public OrderTypeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderTypeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RowIconView, defStyleAttr, 0);
        try {
            rowLabel = typedArray.getResourceId(R.styleable.RowIconView_rowLabel, defStyleAttr);
            rowIcon = typedArray.getResourceId(R.styleable.RowIconView_rowIcon, defStyleAttr);
        } finally {
            typedArray.recycle();
        }
        mTypeImg.setImageResource(rowIcon);
        mTypeLabel.setText(rowLabel);
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_order_type, this);
        ButterKnife.bind(this, view);
        mMsgView.setBadgeBackgroundColor(UIUtil.getColor(R.color.flash_yellow));
        mMsgView.setTextColor(UIUtil.getColor(R.color.white));
    }

    public void setMessage(int count) {
        if(count == 0) {
            mMsgView.setVisibility(GONE);
        } else {
            mMsgView.setVisibility(VISIBLE);
            mMsgView.setText(String.valueOf(count));
        }
    }
}
