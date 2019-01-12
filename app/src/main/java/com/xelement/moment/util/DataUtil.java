package com.xelement.moment.util;

import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.entity.FollowEntity;
import com.xelement.moment.entity.DiscoveryHotEntity;
import com.xelement.moment.entity.DiscoveryItemEntity;
import com.xelement.moment.entity.FollowItemEntity;

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
}
