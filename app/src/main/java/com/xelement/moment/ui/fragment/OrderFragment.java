package com.xelement.moment.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.BaseFragment;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.event.NewEntityEvent;
import com.xelement.moment.ui.adapter.OrderAdapter;
import com.xelement.moment.util.DataUtil;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;
import com.xelement.moment.util.UIUtil;
import com.xelement.moment.widget.custom.SpacesVerticalItemDecoration;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/14.
 */
public class OrderFragment extends BaseFragment {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private OrderAdapter adapter;
    int position;

    @Override
    public int initViewID() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.addItemDecoration(new SpacesVerticalItemDecoration((int) UIUtil.getDimen(R.dimen.x20)));
        adapter = new OrderAdapter(R.layout.adapter_order, new ArrayList<OrderEntity>());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void process() {

        position = getArguments().getInt(Constants.ORDER_TYPE);
        update();
    }

    private void update() {
        if(position == 0) {
            String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
            if(!TextUtils.isEmpty(cache)) {
                adapter.setNewData(GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>(){}));
            } else {
                adapter.setNewData(new ArrayList<OrderEntity>());
            }
        } else if(position == 2) {
            String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
            if(!TextUtils.isEmpty(cache)) {
                List<OrderEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
                });
                List<OrderEntity> entityList = new ArrayList<>();
                for(OrderEntity entity : entities) {
                    if(entity.status == 0){
                        entityList.add(entity);
                    }
                }
                adapter.setNewData(entityList);
            } else {
                adapter.setNewData(new ArrayList<OrderEntity>());
            }
        } else if(position == 3) {
            String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
            if(!TextUtils.isEmpty(cache)) {
                List<OrderEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
                });
                List<OrderEntity> entityList = new ArrayList<>();
                for(OrderEntity entity : entities) {
                    if(entity.status == 1){
                        entityList.add(entity);
                    }
                }
                adapter.setNewData(entityList);
            } else {
                adapter.setNewData(new ArrayList<OrderEntity>());
            }
        } else {
            adapter.setNewData(new ArrayList<OrderEntity>());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void newEntityEvent(NewEntityEvent event) {
        String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
        if(!TextUtils.isEmpty(cache)) {
            List<OrderEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
            });
            for(OrderEntity entity : entities) {
                if(entity.time.equals(event.entity.time)) {
                    entity = event.entity;
                }
            }
            PreferenceHelper.putString(Constants.ORDER_DATA, GsonUtil.array2Json(entities));
        }
        update();
    }
}
