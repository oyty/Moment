package com.xelement.moment.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.applikeysolutions.cosmocalendar.model.Day;
import com.applikeysolutions.cosmocalendar.model.Month;
import com.applikeysolutions.cosmocalendar.utils.SelectionType;
import com.applikeysolutions.cosmocalendar.view.CalendarView;
import com.google.gson.reflect.TypeToken;
import com.xelement.moment.R;
import com.xelement.moment.base.Constants;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.ui.adapter.PlanItemAdapter;
import com.xelement.moment.util.GsonUtil;
import com.xelement.moment.util.PreferenceHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/14.
 */
public class PlanFragment extends com.xelement.moment.base.BaseFragment {

    @BindView(R.id.mCalendarView)
    CalendarView mCalendarView;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private PlanItemAdapter adapter;

    @Override
    public int initViewID() {
        return R.layout.fragment_plan;
    }

    @Override
    protected void initView() {
        mCalendarView.setCalendarOrientation(OrientationHelper.HORIZONTAL);
        mCalendarView.setSelectionType(SelectionType.MULTIPLE);

        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setSmoothScrollbarEnabled(true);
        manager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);

        mRecyclerView.setAdapter(adapter = new PlanItemAdapter(R.layout.adapter_plan_item, new ArrayList<OrderEntity>()));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void process() {

        String cache = PreferenceHelper.getString(Constants.ORDER_DATA);
        if(!TextUtils.isEmpty(cache)) {
            List<OrderEntity> entities = GsonUtil.json2Array(cache, new TypeToken<List<OrderEntity>>() {
            });
            List<OrderEntity> orderEntities = new ArrayList<>();
            for(OrderEntity entity : entities) {
                if(entity.status == 1) {
                    orderEntities.add(entity);
                }
            }
//            mNumLabel.setText(orderEntities.size() + "");

            adapter.setNewData(orderEntities);

            for(Iterator<Month> monthIterator = mCalendarView.getAdapter().getData().iterator(); monthIterator.hasNext();) {
                Month month = monthIterator.next();
                for(Iterator<Day> dayIterator = month.getDaysWithoutTitlesAndOnlyCurrent().iterator(); dayIterator.hasNext();) {
                    Day day = dayIterator.next();

                    for(OrderEntity entity : orderEntities) {
                        if(day.equals(new Day(entity.getDate()))) {
                            mCalendarView.getSelectionManager().toggleDay(day);
                        }
                    }
                }
            }
        }
    }
}
