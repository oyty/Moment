package com.xelement.moment.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.xelement.moment.R;
import com.xelement.moment.base.BaseAdapter;
import com.xelement.moment.entity.PayTypeEntity;
import com.xelement.moment.widget.custom.PayTypeItemView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oyty on 2018/8/31.
 */
public class PayTypeAdapter extends BaseAdapter<PayTypeEntity> {


    public PayTypeAdapter(Context context, List<PayTypeEntity> lists) {
        super(context, lists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = View.inflate(mContext, R.layout.adapter_pay_type, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PayTypeEntity item = getPositionItem(position);
        viewHolder.mPayTypeItemView.refresh(item, position != getListSize() - 1);
        return convertView;
    }

    class ViewHolder  {

        @BindView(R.id.mPayTypeItemView)
        PayTypeItemView mPayTypeItemView;

        public ViewHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }
}