package com.xelement.moment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.util.CommonUtil;
import com.xelement.moment.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/17.
 */
public class SearchActivity extends BaseActivity {

    @BindView(R.id.mSearchBarView)
    View mSearchBarView;
    @BindView(R.id.mSearchValue)
    EditText mSearchValue;
    @BindView(R.id.mTagLabel1)
    TextView mTagLabel1;
    @BindView(R.id.mTagLabel2)
    TextView mTagLabel2;
    @BindView(R.id.mTagLabel3)
    TextView mTagLabel3;
    @BindView(R.id.mTagLabel4)
    TextView mTagLabel4;
    @BindView(R.id.mTagLabel5)
    TextView mTagLabel5;
    @BindView(R.id.mTagLabel6)
    TextView mTagLabel6;
    @BindView(R.id.mTagLabel7)
    TextView mTagLabel7;
    @BindView(R.id.mTagLabel8)
    TextView mTagLabel8;

    @Override
    public int initViewID() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        CommonUtil.updateStatusBarHeight(mContext, mSearchBarView);
    }

    @Override
    protected void initViewListener() {
        mTagLabel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchValue.setText(mTagLabel1.getText());
                toSearchList(mTagLabel1.getText().toString());
            }
        });
        mTagLabel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchValue.setText(mTagLabel2.getText());
                toSearchList(mTagLabel2.getText().toString());
            }
        });
        mTagLabel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchValue.setText(mTagLabel3.getText());
                toSearchList(mTagLabel3.getText().toString());
            }
        });
        mTagLabel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchValue.setText(mTagLabel4.getText());
                toSearchList(mTagLabel4.getText().toString());
            }
        });
        mTagLabel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchValue.setText(mTagLabel5.getText());
                toSearchList(mTagLabel5.getText().toString());
            }
        });
        mTagLabel6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchValue.setText(mTagLabel6.getText());
                toSearchList(mTagLabel6.getText().toString());
            }
        });
        mTagLabel7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchValue.setText(mTagLabel7.getText());
                toSearchList(mTagLabel7.getText().toString());
            }
        });
        mTagLabel8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchValue.setText(mTagLabel8.getText());
                toSearchList(mTagLabel8.getText().toString());
            }
        });
    }

    private void toSearchList(String data) {
        Intent intent = new Intent(mContext, SearchResultActivity.class);
        intent.putExtra(Constants.SEARCH_DATA, data);
        mContext.startActivity(intent);
    }

    @Override
    protected void process() {

    }

    @OnClick(R.id.mCancelAction)
    public void cancelAction() {
        finish();
    }

    @OnClick(R.id.mSearchAction)
    public void searchAction() {
        String value = mSearchValue.getText().toString().trim();
        if (TextUtils.isEmpty(value)) {
            ToastUtil.show(mContext, "请输入搜索内容");
            return;
        } else {
            mContext.startActivity(new Intent(mContext, SearchResultActivity.class));
        }
    }

}
