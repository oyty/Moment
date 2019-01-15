package com.xelement.moment.ui.fragment;

import android.support.v7.widget.OrientationHelper;

import com.applikeysolutions.cosmocalendar.model.Day;
import com.applikeysolutions.cosmocalendar.model.Month;
import com.applikeysolutions.cosmocalendar.utils.SelectionType;
import com.applikeysolutions.cosmocalendar.view.CalendarView;
import com.xelement.moment.R;

import java.util.Date;
import java.util.Iterator;

import butterknife.BindView;

/**
 * Created by oyty on 2019/1/14.
 */
public class PlanFragment extends com.xelement.moment.base.BaseFragment {

    @BindView(R.id.mCalendarView)
    CalendarView mCalendarView;

    @Override
    public int initViewID() {
        return R.layout.fragment_plan;
    }

    @Override
    protected void initView() {
        mCalendarView.setCalendarOrientation(OrientationHelper.HORIZONTAL);
        mCalendarView.setSelectionType(SelectionType.MULTIPLE);
    }

    @Override
    protected void process() {
        for(Iterator<Month> monthIterator = mCalendarView.getAdapter().getData().iterator(); monthIterator.hasNext();) {
            Month month = monthIterator.next();
            for(Iterator<Day> dayIterator = month.getDaysWithoutTitlesAndOnlyCurrent().iterator(); dayIterator.hasNext();) {
                Day day = dayIterator.next();

                if(day.equals(new Day(new Date()))) {
                    mCalendarView.getSelectionManager().toggleDay(day);
                }
            }
        }
    }
}
