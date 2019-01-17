package com.xelement.moment.util;

import com.xelement.moment.R;
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

    public static List<ProductEntity> getDiscoveryData(int position) {
        List<ProductEntity> entities = new ArrayList<>();
//        if(position == 1) {
            entities.add(new ProductEntity(R.mipmap.p1_1, "适用苹果iphone手机手表耳机三合一充电支架底座硅胶充电座", "96.00", "96.00"));
            entities.add(new ProductEntity(R.mipmap.p1_2, "叮咚 2C智能蓝牙音箱 语音操控海量内容 深空灰", "580.00", "599.00"));
            entities.add(new ProductEntity(R.mipmap.p1_3, "ESALEB 随身厅 智能摄像头高清拍照摄像头 SR030", "198.00", "199.00"));
            entities.add(new ProductEntity(R.mipmap.p1_4, "坚果 电影机投影机家用 1895（1080P全高清 1200流明 复古机械操作）", "9998.00", "9999.00"));
            entities.add(new ProductEntity(R.mipmap.p1_5, "【出口单】游戏机充电宝二合一8000mAh 复古怀旧款 两色可选", "147.00", "499.00"));
            entities.add(new ProductEntity(R.mipmap.p1_6, "【出口单】怀旧掌上游戏机 迷你复古内置经典游戏 六色可选", "68.00", "182.00"));
            entities.add(new ProductEntity(R.mipmap.p1_7, "超广角15X微距手机镜头直播单反摄影外置高清特效 玫瑰金", "57.00", "173.00"));
            entities.add(new ProductEntity(R.mipmap.p1_8, "芭蕾兔挂饰充电宝5200mAh 可爱卡通少女心 三色可选", "83.00", "192.00"));
            entities.add(new ProductEntity(R.mipmap.p1_9, "迷你复古无线蓝牙音箱户外降噪便携式ins风 三色可选", "56.00", "156.4.00"));
            entities.add(new ProductEntity(R.mipmap.p1_10, "亚马逊电商新款蓝牙音箱 emoji表情无线音箱可插线 多表情款式", "122.00", "244.00"));
//        }
        return entities;
    }

    public static List<DiscoveryItemEntity> getDiscoveryItemData() {
        int position = 0;
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

    public static List<ProductEntity> getFresherData() {
        List<ProductEntity> entities = new ArrayList<>();
        ProductEntity entity = new ProductEntity(R.mipmap.fresh1_1, "蓝月亮 深层洁净洗衣液（自然清香）1kg/瓶", "24.90", "1.00");
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.fresh1_1);
        images.add(R.mipmap.fresh1_2);
        images.add(R.mipmap.fresh1_3);
        entity.setImages(images);
        List<String> tags = new ArrayList<>();
        tags.add("薰衣草");
        tags.add("自然清香");
        entity.setTags(tags);
        entity.setClickable(true);
        entity.setComment("昨天用验光笔，用那个，验光笔，验，嗯，京东上同买的奥妙，和这个蓝月亮，奥妙的含荧光剂，蓝月亮不含，才发现，原来洗衣液含荧光剂，以后再买就买蓝月亮，再也不买奥妙了。");
        entities.add(entity);

        ProductEntity entity1 = new ProductEntity(R.mipmap.fresh2_1, "最生活（a-life）毛巾 小米洗脸巾 纯棉强吸水毛巾 全棉加厚面巾 成人家用 3条装 白/蓝/绿", "52.90", "1.00");
        List<Integer> images1 = new ArrayList<>();
        images1.add(R.mipmap.fresh2_1);
        images1.add(R.mipmap.fresh2_2);
        images1.add(R.mipmap.fresh2_3);
        images1.add(R.mipmap.fresh2_4);
        images1.add(R.mipmap.fresh2_5);
        images1.add(R.mipmap.fresh2_6);
        entity1.setImages(images1);
        List<String> tags1 = new ArrayList<>();
        tags1.add("灰白条纹装");
        tags1.add("蓝色条纹运动巾");
        entity1.setTags(tags1);
        entity1.setClickable(true);
        entity1.setComment("之前用过这个毛巾 感觉很好 软软的 还很厚实 这次活动又买了 同价位性价比超赞 有活动还会继续购买");
        entities.add(entity1);


        entities.add(new ProductEntity(R.mipmap.fresh3, "班尼路男装短袖上衣 棉质V领短袖t恤男 纯色圆领体恤", "34.00", "1.00"));
        entities.add(new ProductEntity(R.mipmap.fresh4, "每日坚果大礼包成人款25g小袋装3/7/10/15/30包混合坚果孕妇儿童款果仁干果坚果礼盒", "18.80", "1.00"));
        entities.add(new ProductEntity(R.mipmap.fresh3, "班尼路男装短袖上衣 棉质V领短袖t恤男 纯色圆领体恤", "34.00", "1.00"));
        entities.add(new ProductEntity(R.mipmap.fresh4, "每日坚果大礼包成人款25g小袋装3/7/10/15/30包混合坚果孕妇儿童款果仁干果坚果礼盒", "18.80", "1.00"));
        return entities;
    }
}
