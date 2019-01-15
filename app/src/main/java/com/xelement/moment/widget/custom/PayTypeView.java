package com.xelement.moment.widget.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.xelement.moment.R;
import com.xelement.moment.entity.ConfigEntity;
import com.xelement.moment.entity.PayTypeEntity;
import com.xelement.moment.ui.adapter.PayTypeAdapter;
import com.xelement.moment.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2018/8/31.
 */
public class PayTypeView extends FrameLayout {

    private Context mContext;

    @BindView(R.id.mRecyclerView)
    ListView mRecyclerView;

    private PayTypeAdapter adapter;
    private List<PayTypeEntity> entities = new ArrayList<>();

    public PayTypeView(@NonNull Context context) {
        this(context, null);
    }

    public PayTypeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PayTypeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_pay_type, this);
        ButterKnife.bind(this, view);

        adapter = new PayTypeAdapter(mContext, entities);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateChoosed(position);
                adapter.setDataAndNotify(entities);
            }
        });
    }

    public void refresh(ConfigEntity entity) {
        this.entities = entity.switch_pay;
        updateChoosed(0);
        adapter.setDataAndNotify(entities);

        CommonUtil.setListViewHeightBasedOnChildren(mRecyclerView, entity.switch_pay.size());
    }

    private void updateChoosed(int choosedPosition) {
        for(int i=0; i<entities.size(); i++) {
            entities.get(i).setChoosed(i == choosedPosition);
        }
    }

    public int getPayChannel() {
        for(int i=0; i<entities.size(); i++) {
            if(entities.get(i).isChoosed()) {
                return entities.get(i).pay_channel;
            }
        }
        return 0;
    }

    public int getPayPlatform() {
        for(int i=0; i<entities.size(); i++) {
            if(entities.get(i).isChoosed()) {
                return entities.get(i).pay_platform;
            }
        }
        return 0;
    }


}
