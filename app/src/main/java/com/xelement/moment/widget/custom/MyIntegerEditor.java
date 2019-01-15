package com.xelement.moment.widget.custom;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.xelement.moment.R;
import com.xelement.moment.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cj_zuo on 2017/8/8.
 */

public class MyIntegerEditor extends FrameLayout {
    private final int MAX = 99999;

    private ImageView mSub;
    private ImageView mAdd;
    private EditText mEt;

    private Context mContext;

    private int mNum;
    private int mStepLength = 1;
    private int mMin = 1; //允许的最小值
    private int mMax = MAX; //允许的最大值
    private MyTextWatcher mInnerListener;
    private List<OnAfterTextChangedListener> mListenerList = new ArrayList<>();

    private Integer mStockLimit = mMax;
    private Integer mBuyLimit = mMax;
    private OnActionChangedListener actionListener;

    public void setOnActionChangedListener(OnActionChangedListener listener) {
        this.actionListener = listener;
    }

    public interface OnAfterTextChangedListener {
        void OnAfterTextChanged(int num);
    }

    public void addOnAfterTextChangedListener(OnAfterTextChangedListener mListener) {
        mListenerList.add(mListener);
    }

    public MyIntegerEditor(@NonNull Context context) {
        this(context, null);
    }

    public MyIntegerEditor(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyIntegerEditor(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.mContext = context;
        init();
    }

    public void setMin(int min) {
        mMin = min;
    }

    public void setBuyLimit(int buyLimit) {
        mBuyLimit = buyLimit;
        fixMax();
    }

    public void setStockLimit(int stockLimit) {
        mStockLimit = stockLimit;
        fixMax();
    }

    public EditText getEtView() {
        return mEt;
    }

    public String getTextNum() {
        return mEt.getText().toString().trim();
    }

    public void setTextNum(int num) {
        this.mNum = num;
        mEt.setText("" + num);
    }

    public void setTextNum(String num) {
        try {
            setTextNum(Integer.parseInt(num));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //设置编辑框中的文字而不触发监听器
    public void setTextNum(int num, boolean triggerTextChangedListener) {
        if (triggerTextChangedListener) {
            setTextNum(num);
        } else {
            mEt.removeTextChangedListener(mInnerListener);
            setTextNum(num);
            mEt.addTextChangedListener(mInnerListener);
        }
    }

    private void updateBtnEnableByNum(int currentNum) {
        if (currentNum <= mMin) {
            mSub.setImageResource(R.mipmap.minus_normal);
            mSub.setEnabled(false);
        } else {
            mSub.setImageResource(R.mipmap.minus);
            mSub.setEnabled(true);
        }

        if (currentNum >= mMax) {
            mAdd.setImageResource(R.mipmap.plus_normal);
            mAdd.setEnabled(false);
        } else {
            mAdd.setImageResource(R.mipmap.plus);
            mAdd.setEnabled(true);
        }
    }

    private void warningBeyondThreshold(int currentNum) {
        if (currentNum < mMin) {
            ToastUtil.show(mContext, "请输入一个不小于" + mMin + "的数字");
        } else if (currentNum > mStockLimit) {
            ToastUtil.show(mContext, "超出库存数量范围");
        } else if (currentNum > mBuyLimit) {
            ToastUtil.show(mContext, "超出限购件数");
        }
    }

    private void fixMax() {
        if (mBuyLimit != null && mStockLimit != null) {
            mMax = Math.min(mBuyLimit, mStockLimit);
        } else if (mBuyLimit != null) {
            mMax = mBuyLimit;
        } else {
            mMax = mStockLimit;
        }
        mMax = Math.max(mMax, mMin);
    }

    private void init() {
        initView();
        initListener();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_common_editor, this);
        mSub = view.findViewById(R.id.sub);
        mAdd = view.findViewById(R.id.add);
        mEt = view.findViewById(R.id.et);

        //不允许输入小数
        mEt.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
        //默认设置为最小值，减号不可点
        setTextNum(mMin);
        updateBtnEnableByNum(mMin);
    }

    private void initListener() {
        mSub.setOnClickListener(new MyOnClickListener());
        mAdd.setOnClickListener(new MyOnClickListener());

        mEt.setOnEditorActionListener(new MyEditorActionListener());
        mInnerListener = new MyTextWatcher();
        mEt.addTextChangedListener(mInnerListener);
    }

    private class MyOnClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            //得到输入框里的数字
            String numString = mEt.getText().toString().trim();
            if (TextUtils.isEmpty(numString)) {
                mNum = mStepLength;
            } else {
                try {
                    mNum = Integer.parseInt(numString);
                    switch (v.getId()) {
                        case R.id.sub: {
                            if (mNum - mStepLength > mMin) {
                                mNum -= mStepLength;
                            } else {
                                mNum = mMin;
                            }
                            break;
                        }
                        case R.id.add: {
                            if (mNum + mStepLength < mMax) {
                                mNum += mStepLength;
                            } else {
                                mNum = mMax;
                            }
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            mEt.setText("" + mNum);
            if(actionListener != null) {
                actionListener.onActionChanged();
            }
        }
    }

    private class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            String numString = s.toString().trim();
            if (TextUtils.isEmpty(numString)) {

            } else {
                mNum = Integer.parseInt(numString);
                warningBeyondThreshold(mNum);

                if (mNum < mMin) {
                    mNum = mMin;
                    mEt.setText("" + mNum);
                } else if (mNum > mMax) {
                    mNum = mMax;
                    mEt.setText("" + mNum);
                } else {
                    //设置EditText光标位置 为文本末端
                    mEt.setSelection(mEt.getText().toString().length());

                    for (int i = 0; i < mListenerList.size(); i++) {
                        mListenerList.get(i).OnAfterTextChanged(mNum);
                    }
                }

                updateBtnEnableByNum(mNum);
            }
        }
    }

    private class MyEditorActionListener implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (mNum % mStepLength != 0) {
                if (mNum < mStepLength) {
                    mNum = mStepLength;
                } else {
                    mNum -= mNum % mStepLength;
                }
                mEt.setText("" + mEt);
            }
            return false;
        }
    }

    public void clearNumFocus() {
        mEt.clearFocus();
    }

    public interface OnActionChangedListener {
        void onActionChanged();
    }
}
