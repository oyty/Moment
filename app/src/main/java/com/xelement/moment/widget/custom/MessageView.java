package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.xelement.moment.R;
import com.xelement.moment.ui.activity.AdmireDetailActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/12.
 */
public class MessageView extends FrameLayout {

    private final Context mContext;

    public MessageView(@NonNull Context context) {
        this(context, null);
    }

    public MessageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MessageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_message, this);
        ButterKnife.bind(this, view);
    }

}
