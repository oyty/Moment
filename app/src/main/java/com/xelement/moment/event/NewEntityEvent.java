package com.xelement.moment.event;

import com.xelement.moment.entity.OrderEntity;

/**
 * Created by oyty on 2019/1/16.
 */
public class NewEntityEvent {
    public OrderEntity entity;

    public NewEntityEvent(OrderEntity entity) {
        this.entity = entity;
    }
}
