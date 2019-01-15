package com.xelement.moment.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.entity.MessageEntity;
import com.xelement.moment.ui.adapter.MessageAdapter;
import com.xelement.moment.util.DataUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/15.
 */
public class MessageActivity extends BaseActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private MessageAdapter adapter;

    @Override
    public int initViewID() {
        return R.layout.activity_message;
    }

    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter = new MessageAdapter(R.layout.adapter_message, new ArrayList<MessageEntity>()));
    }

    @Override
    protected void process() {
        adapter.setNewData(DataUtil.getMessageData());
    }
}
