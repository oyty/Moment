package com.xelement.moment.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.MessageEntity;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.ui.adapter.MessageAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.widget.custom.PublicTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/15.
 */
public class MessageActivity extends BaseActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private MessageAdapter adapter;

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("最新通知");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_message;
    }

    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter = new MessageAdapter(R.layout.adapter_message, new ArrayList<OrderEntity>()));
    }

    @Override
    protected void process() {

        String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
        if (!TextUtils.isEmpty(cache)) {
            List<OrderEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
            });

            adapter.setNewData(entities);
        }


    }
}

