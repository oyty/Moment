package com.xelement.moment.util;

import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.entity.FollowEntity;
import com.xelement.moment.entity.DiscoveryHotEntity;
import com.xelement.moment.entity.DiscoveryItemEntity;
import com.xelement.moment.entity.FollowItemEntity;
import com.xelement.moment.entity.MessageEntity;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.entity.PlanGroupEntity;
import com.xelement.moment.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class DataUtil {
    public static List<DiscoveryHotEntity> getDiscoveryHotData() {
        List<DiscoveryHotEntity> entities = new ArrayList<>();
        entities.add(new DiscoveryHotEntity());
        entities.add(new DiscoveryHotEntity());
        entities.add(new DiscoveryHotEntity());
        entities.add(new DiscoveryHotEntity());
        return entities;
    }

    public static List<FollowEntity> getFollowData() {
        List<FollowEntity> entities = new ArrayList<>();
        entities.add(new FollowEntity());
        entities.add(new FollowEntity());
        entities.add(new FollowEntity());
        entities.add(new FollowEntity());
        return entities;
    }

    public static List<DiscoveryItemEntity> getDiscoveryItemData() {
        List<DiscoveryItemEntity> entities = new ArrayList<>();
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        entities.add(new DiscoveryItemEntity());
        return entities;
    }

    public static List<AdmireEntity> getAdmireData() {
        List<AdmireEntity> entities = new ArrayList<>();
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        entities.add(new AdmireEntity());
        return entities;
    }

    public static List<FollowItemEntity> getFollowItemData() {
        List<FollowItemEntity> entities = new ArrayList<>();
        entities.add(new FollowItemEntity());
        entities.add(new FollowItemEntity());
        entities.add(new FollowItemEntity());
        return entities;
    }

    public static List<PlanGroupEntity> getPlanWeekData() {
        PlanGroupEntity entity = new PlanGroupEntity();
        entity.time = "2019.1.15";
        entity.title = "本周二有2件商品签收";
        entity.entities = new ArrayList<>();
        entity.entities.add(new ProductEntity());
        entity.entities.add(new ProductEntity());

        PlanGroupEntity entity1 = new PlanGroupEntity();
        entity1.time = "2019.1.16";
        entity1.title = "本周三有3件商品签收";
        entity1.entities = new ArrayList<>();
        entity1.entities.add(new ProductEntity());
        entity1.entities.add(new ProductEntity());
        entity1.entities.add(new ProductEntity());

        List<PlanGroupEntity> entities = new ArrayList<>();
        entities.add(entity);
        entities.add(entity1);
        return entities;
    }

    public static List<ProductEntity> getStoreProductData() {
        List<ProductEntity> entities = new ArrayList<>();
        entities.add(new ProductEntity());
        entities.add(new ProductEntity());
        entities.add(new ProductEntity());
        entities.add(new ProductEntity());
        entities.add(new ProductEntity());
        entities.add(new ProductEntity());
        entities.add(new ProductEntity());
        return entities;
    }

    public static List<OrderEntity> getOrderData() {
        List<OrderEntity> entities = new ArrayList<>();
        entities.add(new OrderEntity());
        entities.add(new OrderEntity());
        entities.add(new OrderEntity());
        entities.add(new OrderEntity());
        entities.add(new OrderEntity());
        entities.add(new OrderEntity());
        return entities;
    }

    public static List<ProductEntity> getAdmireDetailData() {
        List<ProductEntity> entities = new ArrayList<>();
        entities.add(new ProductEntity());
        entities.add(new ProductEntity());
        return entities;
    }

    public static List<MessageEntity> getMessageData() {
        List<MessageEntity> entities = new ArrayList<>();
        entities.add(new MessageEntity());
        entities.add(new MessageEntity());
        entities.add(new MessageEntity());
        entities.add(new MessageEntity());
        return entities;
    }
}
