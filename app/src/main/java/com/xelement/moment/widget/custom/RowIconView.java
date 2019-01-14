package com.xelement.moment.widget.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.xelement.moment.R;
import com.xelement.moment.util.UIUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RowIconView extends FrameLayout {

    private Context mContext;
    @BindView(R.id.mRowLabel)
    TextView mRowLabel;
    @BindView(R.id.mPlaceholderLabel)
    TextView mPlaceholderLabel;
    @BindView(R.id.mRowIconImg)
    ImageView mRowIconImg;
    @BindView(R.id.mRowValue)
    TextView mRowValue;
    @BindView(R.id.mArrowImg)
    ImageView mArrowImg;
    @BindView(R.id.mPotView)
    View mPotView;
    @BindView(R.id.mMsgLabel)
    TextView mMsgLabel;
    @BindView(R.id.mSwitchView)
    Switch mSwitchView;

    private int rowLabel;
    private int rowValueHint;
    private int rowIcon;
    private boolean showArrow;
    private boolean showSwitch;
    private int labelColor = UIUtil.getColor(R.color.flash_black);
    private int rowType;

    public RowIconView(Context context) {
        this(context, null);
    }

    public RowIconView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RowIconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RowIconView, defStyleAttr, 0);
        try {
            labelColor = typedArray.getColor(R.styleable.RowIconView_labelColor, labelColor);
            rowLabel = typedArray.getResourceId(R.styleable.RowIconView_rowLabel, defStyleAttr);
            rowValueHint = typedArray.getResourceId(R.styleable.RowIconView_rowValueHint, defStyleAttr);
            rowIcon = typedArray.getResourceId(R.styleable.RowIconView_rowIcon, defStyleAttr);
            showArrow = typedArray.getBoolean(R.styleable.RowIconView_showArrow, false);
            showSwitch = typedArray.getBoolean(R.styleable.RowIconView_showSwitch, false);
            rowType = typedArray.getInteger(R.styleable.RowIconView_rowType, 1);
        } finally {
            typedArray.recycle();
        }
        if (rowLabel != 0) {
            mRowLabel.setText(UIUtil.getString(rowLabel));
        }
        if (rowIcon != 0) {
            mRowIconImg.setBackgroundResource(rowIcon);
            mRowIconImg.setVisibility(VISIBLE);
        }

        if (rowValueHint != 0) {
            mRowValue.setHint(rowValueHint);
        }

        if (rowType == 0) {
            mRowValue.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            int length = UIUtil.getString(rowLabel).length();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 5 - length; i++) {
                sb.append("好");
            }
            mPlaceholderLabel.setText(sb.toString());
        } else {
            mRowValue.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
        }
        mSwitchView.setVisibility(showSwitch ? VISIBLE : GONE);
        mArrowImg.setVisibility(showArrow ? VISIBLE : GONE);
        mRowLabel.setTextColor(labelColor);
    }

    public void setLabel(String label) {
        mRowLabel.setText(label);
    }

    public void setValue(String rowValue) {
        mRowValue.setText(rowValue);
    }

    public void setHint(String rowHint) {
        setValue("");
        mRowValue.setHint(rowHint);
    }

    public String getValue() {
        return mRowValue.getText().toString().trim();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_row_icon, this);
        ButterKnife.bind(this, view);
    }

    public void showPot(boolean isShow) {
        mPotView.setVisibility(isShow ? VISIBLE : GONE);
    }

    public String getTab() {
        return mPotView.getVisibility() == VISIBLE ? "1" : "0";
    }

    public void setMsg(String msg) {
        if (TextUtils.isEmpty(msg)) {
            mMsgLabel.setVisibility(GONE);
        } else {
            mMsgLabel.setVisibility(VISIBLE);
            mMsgLabel.setText(msg);
        }
    }

    public void setSwitch(boolean flag) {
        mSwitchView.setChecked(flag);
    }

    public boolean getSwitchValue() {
        return mSwitchView.isChecked();
    }

    public void setOnCheckedListener(CompoundButton.OnCheckedChangeListener listener) {
        mSwitchView.setOnCheckedChangeListener(listener);
    }
}
