package com.xelement.moment.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by oyty on 2019/1/14.
 */
public class PlanMultipleType implements MultiItemEntity {

    private int itemType;

    @Override
    public int getItemType() {
        return itemType;
    }
}
