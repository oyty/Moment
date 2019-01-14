package com.xelement.moment.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseActivity;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.AddressEntity;
import com.xelement.moment.ui.adapter.AddressItemAdapter;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.widget.custom.PublicTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by oyty on 2019/1/14.
 */
public class AddressActivity extends BaseActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private List<AddressEntity> entities = new ArrayList<>();
    private AddressItemAdapter adapter;
    private AddressEntity choosedEntity;

    @Override
    public void initTitleBar(PublicTitleView titleView) {
        super.initTitleBar(titleView);
        titleView.setTitle("地址管理");
    }

    @Override
    public int initViewID() {
        return R.layout.activity_address;
    }


    @Override
    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new AddressItemAdapter(R.layout.adapter_address_item, entities);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void process() {

    }

    @Override
    protected void onResume() {
        super.onResume();

        String cache = PreferenceHelper.getString(Constants.ADDRESS_DATA);
        if(!TextUtils.isEmpty(cache)) {
            List<AddressEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<AddressEntity>>(){});
            adapter.setNewData(entities);
        }
    }

    @OnClick(R.id.mAddNewAddressAction)
    public void addressAction() {
        startActivity(new Intent(mContext, EditAddressActivity.class));
    }
}
