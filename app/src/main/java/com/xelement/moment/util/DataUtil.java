package com.xelement.moment.util;

import com.xelement.moment.R;
import com.xelement.moment.entity.AdmireEntity;
import com.xelement.moment.entity.AdmireItemEntity;
import com.xelement.moment.entity.DaysEntity;
import com.xelement.moment.entity.FollowEntity;
import com.xelement.moment.entity.DiscoveryHotEntity;
import com.xelement.moment.entity.DiscoveryItemEntity;
import com.xelement.moment.entity.FollowItemEntity;
import com.xelement.moment.entity.MessageEntity;
import com.xelement.moment.entity.OrderEntity;
import com.xelement.moment.entity.PlanGroupEntity;
import com.xelement.moment.entity.ProductEntity;
import com.xelement.moment.entity.UserEntity;

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
        if (position == 1) {
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
        } else if (position == 2) {
            entities.add(new ProductEntity(R.mipmap.p2_1, "顽皮（Wanpy）宠物猫咪零食 鸡肉条 25g*12袋", "61.00", "78.00"));
            entities.add(new ProductEntity(R.mipmap.p2_2, "耐威克狗粮 三文鱼牛油果天然粮1.5kg 天然美毛祛泪痕", "90.00", "101.50"));
            entities.add(new ProductEntity(R.mipmap.p2_3, "蛙牌WA! 幼猫粮1.5KG 宝贝向前冲系列C2019 宠物主粮", "93.00", "139.00"));
            entities.add(new ProductEntity(R.mipmap.p2_4, "顽皮Happy100 狗湿粮 狗零食 牛肉慕斯犬罐头95g*24罐", "112.00", "121.00"));
            entities.add(new ProductEntity(R.mipmap.p2_5, "阿飞和巴弟 Alfie&Buddy 猫罐头猫零食 白肉汤罐纯金枪鱼80g*24罐整箱装", "192.00", "199.00"));
            entities.add(new ProductEntity(R.mipmap.p2_6, "麦富迪 狗粮鲜肉软粮幼犬老年犬通用牛肉味1.02kg*5", "221.00", "235.00"));
            entities.add(new ProductEntity(R.mipmap.p2_7, "麦富迪 猫粮藻趣儿螺旋藻三文鱼通用成猫粮10kg", "249.00", "265.00"));
            entities.add(new ProductEntity(R.mipmap.p2_8, "元气匠心 能量蛋 狗狗零食补钙湿粮罐头 芝士内芯 整箱26颗", "107.00", "115.00"));
            entities.add(new ProductEntity(R.mipmap.p2_9, "顽皮Happy100猫猫咪罐头湿粮  金枪鱼肉慕斯猫罐头95g*24罐", "112.00", "121.00"));
            entities.add(new ProductEntity(R.mipmap.p2_10, "爱慕思（IAMS）宠物成猫猫粮 三文鱼味 1.5kg", "123.00", "139.00"));
        } else if (position == 3) {
            entities.add(new ProductEntity(R.mipmap.p3_1, "2018秋冬女韩版宽松甜美闺蜜装 女 粉色套装 均码", "98.00", "206.00"));
            entities.add(new ProductEntity(R.mipmap.p3_2, "INTERIGHT 白鸭绒女超轻羽绒服", "398.00", "437.90"));
            entities.add(new ProductEntity(R.mipmap.p3_3, "NEW BALANCE AWP73529-AG 女款休闲针织长裤", "298.00", "325.00"));
            entities.add(new ProductEntity(R.mipmap.p3_4, "INTERIGHT 女士修身弹力小脚时尚百搭抓毛保暖牛仔裤 深蓝", "238.00", "268.90"));
            entities.add(new ProductEntity(R.mipmap.p3_5, "INTERIGHT 女士毛圈舒适针织运动休闲裤 黑色", "138.00", "168.90"));
            entities.add(new ProductEntity(R.mipmap.p3_6, "INTERIGHT 女士连帽套头毛圈外套 花灰", "138.00", "158.90"));
            entities.add(new ProductEntity(R.mipmap.p3_7, "INTERIGHT 女士摇粒绒立领拉链开衫休闲外套 紫罗兰", "138.00", "158.90"));
            entities.add(new ProductEntity(R.mipmap.p3_8, "INTERIGHT 女士连帽套头毛圈外套 松石绿", "138.00", "158.90"));
            entities.add(new ProductEntity(R.mipmap.p3_9, "INTERIGHT 女士摇粒绒立领拉链开衫休闲外套 番茄红", "138.00", "159.00"));
            entities.add(new ProductEntity(R.mipmap.p3_10, "INTERIGHT 女士摇粒绒立领拉链开衫休闲外套 黑色", "138.00", "157.00"));
        } else if (position == 4) {
            entities.add(new ProductEntity(R.mipmap.p5_1, "新款去毛球修剪器 充电型衣物除毛六刀头 粉白色", "90.00", "90.00"));
            entities.add(new ProductEntity(R.mipmap.p5_2, "新款创意按摩梳 电镀逗号 防打结 两色可选", "32.00", "79.90"));
            entities.add(new ProductEntity(R.mipmap.p5_3, "宝莹 Persil 敏感肤质洗衣凝露洗衣液2.2L （温和无刺激 进口洗衣液）", "198.00", "259.00"));
            entities.add(new ProductEntity(R.mipmap.p5_4, "飞达三和 置物架落地带轮置物架浴室多层置物架 A1244", "148.00", "219.00"));
            entities.add(new ProductEntity(R.mipmap.p5_5, "立白 天然皂液2.1kg/瓶+威王 消毒液1.25L/瓶+1L*4袋", "110.00", "159.90"));
            entities.add(new ProductEntity(R.mipmap.p5_6, "艺姿 对折式挤水胶棉拖把清洁工具 28cm胶棉 YZ-JM03", "50.00", "90.00"));
            entities.add(new ProductEntity(R.mipmap.p5_7, "美乐佳 强力夹子 6只 特大号16cm不锈钢晒被子固定防风夹", "35.00", "69.00"));
            entities.add(new ProductEntity(R.mipmap.p5_8, "伴侣行 小麦系列旅行便携男女牙膏牙刷收纳盒  BL1088 北欧黄", "19.00", "19.90"));
            entities.add(new ProductEntity(R.mipmap.p5_9, "绿之源 浴室吸水地垫 U形马桶垫纤维防水防滑三件套（黑猫）", "174.00", "199.00"));
            entities.add(new ProductEntity(R.mipmap.p5_10, "绿之源浴室吸水地垫 U形马桶垫纤维防水防滑三件套（红心）", "174.00", "199.00"));
        } else if (position == 5) {
            entities.add(new ProductEntity(R.mipmap.p6_1, "汤臣倍健 维生素C橘子味（600mg/片x120片）补充VC 可搭配VE", "90.00", "98.00"));
            entities.add(new ProductEntity(R.mipmap.p6_2, "芝麻官 多味米花糖礼盒1600g", "158.00", "196.00"));
            entities.add(new ProductEntity(R.mipmap.p6_3, "芝麻官 芝麻杆 重庆特产大礼包装盒1280g", "125.00", "196.00"));
            entities.add(new ProductEntity(R.mipmap.p6_4, "俏香阁 每日坚果 10袋装 2019年货礼盒 京喜有礼1845g/盒", "180.00", "228.00"));
            entities.add(new ProductEntity(R.mipmap.p6_5, "新农哥 坚果零食礼盒1548g（新老包装交替发货）", "198.00", "289.00"));
            entities.add(new ProductEntity(R.mipmap.p6_6, "Noble贵族 康比特花色夹心巧克力金禧听装 年货礼盒400g", "218.00", "399.00"));
            entities.add(new ProductEntity(R.mipmap.p6_7, "姿美堂 SIMEITOL 天然维生素E软胶囊 400mg/粒*100粒", "40.00", "59.00"));
            entities.add(new ProductEntity(R.mipmap.p6_8, "怀山堂 铁棍山药红豆薏米粉 复960g 480g*2", "198.00", "236.00"));
            entities.add(new ProductEntity(R.mipmap.p6_9, "马来西亚进口 GPR黄油曲奇饼干铁盒340g", "23.00", "39.90"));
            entities.add(new ProductEntity(R.mipmap.p6_10, "十月稻田 糯米 400g", "8.00", "18.54"));
        } else if (position == 6) {
            entities.add(new ProductEntity(R.mipmap.p7_1, "金稻 硅胶电动洁面仪刷 脸部震动按摩清洁毛孔 KD-3031B", "39.00", "39.00"));
            entities.add(new ProductEntity(R.mipmap.p7_2, "金稻 祛黑头铲皮机 精华导入 脸部清洁美容仪 KD-8020", "274.00", "406.00"));
            entities.add(new ProductEntity(R.mipmap.p7_3, "金稻 彩光导入导出电子美容仪 脸部按摩 KD-9900", "498.00", "498.00"));
            entities.add(new ProductEntity(R.mipmap.p7_4, "金稻 眼部按摩营养导入电动美容仪 KD-8909", "38.00", "38.00"));
            entities.add(new ProductEntity(R.mipmap.p7_5, "金稻 温热护理家用电子美容仪 KD-7910", "108.00", "108.00"));
            entities.add(new ProductEntity(R.mipmap.p7_6, "智能usb可充电懒人自动化妆刷清洗器 10秒速甩干 两色可选", "164.00", "313.00"));
            entities.add(new ProductEntity(R.mipmap.p7_7, "【出口单】跨境热销直发梳 家用电吹风负离子欧规国内可用 三色可选", "399.00", "399.00"));
            entities.add(new ProductEntity(R.mipmap.p7_8, "脸部精华按摩仪器 家用超声波离子导入美容仪", "499.00", "499.00"));
            entities.add(new ProductEntity(R.mipmap.p7_9, "吸黑头粉刺神器 家用毛孔清洁小气泡美容仪", "198.00", "198.00"));
            entities.add(new ProductEntity(R.mipmap.p7_10, "石墨烯电动美胸仪器揉捏多功能美胸胸部按摩器", "299.00", "299.00"));
        } else if (position == 7) {
            entities.add(new ProductEntity(R.mipmap.p8_1, "新款纯棉可爱鲨鱼宝宝睡袋 抱被防踢被0-12个月适用  多色可选", "166.00", "218.00"));
            entities.add(new ProductEntity(R.mipmap.p8_2, "冬季新品婴儿帽子 厚款胎帽加脚套 米白色", "130.00", "130.00"));
            entities.add(new ProductEntity(R.mipmap.p8_3, "新品卡通超柔法兰绒羊羔绒宝宝抱被 小熊玩偶2件套", "166.00", "186.00"));
            entities.add(new ProductEntity(R.mipmap.p8_4, "中国儿童百科全书（普及版 套装共10册）", "63.00", "114.00"));
            entities.add(new ProductEntity(R.mipmap.p8_5, "儿童秋冬加绒加厚打底衫  六色可选", "33.00", "120.00"));
            entities.add(new ProductEntity(R.mipmap.p8_6, "彩书坊：一千零一夜 经典童书畅销系列", "38.00", "66.00"));
            entities.add(new ProductEntity(R.mipmap.p8_7, "儿童秋冬加绒加厚打底裤 五色可选", "33.00", "75.25"));
            entities.add(new ProductEntity(R.mipmap.p8_8, "彩书坊：365夜宝宝睡前故事 亲子互动睡前启蒙", "38.00", "66.00"));
            entities.add(new ProductEntity(R.mipmap.p8_9, "儿童棉裤秋冬加绒加厚 四色可选", "46.00", "89.00"));
            entities.add(new ProductEntity(R.mipmap.p8_10, "顶级大师绘本·彼得兔全集（注音版 套装全10册）畅销110周年", "109.00", "149.30"));
        } else if (position == 8) {

            entities.add(new ProductEntity(R.mipmap.p9_1, "冬季新款时尚大容量毛绒手提包女 米白色", "114.00", "114.00"));
            entities.add(new ProductEntity(R.mipmap.p9_2, "冬季新品洋气羊羔毛手拿包女 两色可选", "89.00", "89.00"));
            entities.add(new ProductEntity(R.mipmap.p9_3, "韩版牛津帆布双肩包女大号 学院风大容量 三色可选", "138.00", "138.00"));
            entities.add(new ProductEntity(R.mipmap.p9_4, "【出口单】新款原创中国风双肩包 音乐USB韩版外出休闲系列男 三款可选", "90.00", "116.00"));
            entities.add(new ProductEntity(R.mipmap.p9_5, "美旅箱包 Hiker系列双肩背包 BH6*09001 黑色", "100.00", "119.00"));
            entities.add(new ProductEntity(R.mipmap.p9_6, "亨得利 男女时尚休闲旅行背包韩版学院风书包 0038 灰色", "160.00", "179.00"));
            entities.add(new ProductEntity(R.mipmap.p9_7, "JANSPORT 叛逆系列双肩包背包书包 T501WHX 白色", "198.00", "208.00"));
            entities.add(new ProductEntity(R.mipmap.p9_8, "LATIT 24英寸万向轮PC铝框旅行行李箱 黑色", "740.00", "765.00"));
            entities.add(new ProductEntity(R.mipmap.p9_9, "耶洛谜 胶囊洗漱杯旅行套装 YM32 蓝色", "20.00", "21.50"));
            entities.add(new ProductEntity(R.mipmap.p9_10, "唯加 14/15.6英寸笔记本包旅行背包男女书包防泼水usb充电 WP9399 黑色", "198.00", "199.00"));
        } else if (position == 9) {
            entities.add(new ProductEntity(R.mipmap.p10_1, "健身器材腹肌贴 腹肌训练器 家用懒人健身仪", "102.00", "204.00"));
            entities.add(new ProductEntity(R.mipmap.p10_2, "跨境专供户外骑行运动双肩背包 防雨罩反光防水防尘防脏驮包套 25-40L 三色可选", "168.00", "168.00"));
            entities.add(new ProductEntity(R.mipmap.p10_3, "跨境专供户外骑行防水包 野营登山急救品收纳单肩手机防水袋8L 红色", "103.00", "206.00"));
            entities.add(new ProductEntity(R.mipmap.p10_4, "漂流游泳防水袋 进口PVC夹网布 沙滩防水桶包10L 多色可选", "100.00", "100.00"));
            entities.add(new ProductEntity(R.mipmap.p10_5, "自行车骑行减震止滑手套 高弹透气全指灵敏触屏 男女可用", "100.20", "100.20"));
            entities.add(new ProductEntity(R.mipmap.p10_6, "亚马逊热卖 冬季骑行防风防寒头套护脸保暖面罩 男女可用", "80.00", "116.00"));
            entities.add(new ProductEntity(R.mipmap.p10_7, "背心式越野跑步背包 马拉松跑步骑行登山背水袋 E906", "228.00", "228.00"));
            entities.add(new ProductEntity(R.mipmap.p10_8, "奥尼捷防沙鞋套 男女户外登山徒步越野跑防水耐磨防泥防虫防沙鞋套 三色可选", "118.00", "118.00"));
            entities.add(new ProductEntity(R.mipmap.p10_9, "跨境专供 秋冬户外中空棉保暖吊床 迷彩睡袋 露营垂钓便携保温罩", "250.00", "300.00"));
            entities.add(new ProductEntity(R.mipmap.p10_10, "跨境专供户外野营保暖罩 防风御寒 休闲棉吊床配件230*110cm 多色可选", "226.00", "270.00"));
        } else if (position == 10) {
            entities.add(new ProductEntity(R.mipmap.p11_1, "【出口单】韩国个性S925银针天然淡水珍珠耳环 时尚百搭简约气质女", "30.00", "43.00"));
            entities.add(new ProductEntity(R.mipmap.p11_2, "2019年新款猪年转运编织手链女 本命年红绳 铜镀金", "53.00", "180.00"));
            entities.add(new ProductEntity(R.mipmap.p11_3, "【出口单】欧美大牌时尚走秀款 个性人像合金耳线", "28.00", "69.00"));
            entities.add(new ProductEntity(R.mipmap.p11_4, "韩版蝴蝶结耳钉女 皇冠桃心一周不重复 礼盒套装", "76.00", "76.00"));
            entities.add(new ProductEntity(R.mipmap.p11_5, "【出口单】2019新款铜质锆石电镀贝珠胸针 欧美复古珍珠图案 三款可选", "80.00", "80.00"));
            entities.add(new ProductEntity(R.mipmap.p11_6, "简约创意双层毛衣链 时尚百变长款流行复古吊坠", "42.00", "42.00"));
            entities.add(new ProductEntity(R.mipmap.p11_7, "欧美双层性感人物头像吊坠项链 气质几何圆形合金", "46.00", "46.00"));
            entities.add(new ProductEntity(R.mipmap.p11_8, "欧美风原创设计 幸运太阳女神金属长款项链", "79.60", "79.60"));
            entities.add(new ProductEntity(R.mipmap.p11_9, "2019年日韩创意简约手链 本命年红色珠串三层缠绕弹力绳", "42.00", "84.00"));
            entities.add(new ProductEntity(R.mipmap.p11_10, "【出口单】韩国ins小众设计新款耳环 东大门14K金S925银针网红气质耳饰 白色", "90.00", "90.00"));
        }
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
        AdmireEntity entity1 = new AdmireEntity();
        entity1.setClickable(true);
        UserEntity userEntity1 = new UserEntity();
        userEntity1.nickname = "mome酱";
        userEntity1.tags = new ArrayList<>();
        userEntity1.tags.add("美妆博主");
        userEntity1.likes = "9711";
        userEntity1.image = R.mipmap.au_1;
        userEntity1.desc = "学生党秋季开学必备彩妆！";
        entity1.user = userEntity1;
        List<AdmireItemEntity> itemEntities1 = new ArrayList<>();

        AdmireItemEntity itemEntity1 = new AdmireItemEntity();
        itemEntity1.title = "兰蔻奇迹薄纱粉底液";
        itemEntity1.sell_points1 = "滋润保湿不卡粉";
        itemEntity1.sell_points2 = "清透裸妆不闷痘";
        itemEntity1.sell_points3 = "跟单有返利，最高可返2%";
        itemEntity1.desc = "这款算是比较轻薄的一款粉底液了，很细腻，上脸滋润有光泽，不卡粉。遮瑕力OK，搭配美妆蛋或粉底刷用，妆感服帖";
        itemEntity1.mall_price = "480.00";
        itemEntity1.current_price = "180.00";
        itemEntity1.deposit = "18.00";
        itemEntity1.days = "15";
        itemEntity1.image = R.mipmap.a1_1;

        AdmireItemEntity itemEntity2 = new AdmireItemEntity();
        itemEntity2.title = "nars腮红";
        itemEntity2.sell_points1 = "立体妆容，带点橘红不夸张";
        itemEntity2.sell_points2 = "修饰脸型，立体V脸";
        itemEntity2.sell_points3 = "跟单有返利，最高可返2%";
        itemEntity2.desc = "盒子就很有质感，颜色美腻，带细闪，阳光下美到不行。显色度很高，简单一刷就有好气色，但是就算手重，也不容易红屁股。非常适合白皮，而且我这种大毛孔也没有很明显。";
        itemEntity2.mall_price = "229.00";
        itemEntity2.current_price = "129.00";
        itemEntity2.deposit = "12.90";
        itemEntity2.days = "15";
        itemEntity2.image = R.mipmap.a1_2;

        AdmireItemEntity itemEntity3 = new AdmireItemEntity();
        itemEntity3.title = "colourpop土豆泥眼影";
        itemEntity3.sell_points1 = "裸妆修容不飞粉";
        itemEntity3.sell_points2 = "自然闪亮不晕妆";
        itemEntity3.sell_points3 = "跟单有返利，最高可返2%";
        itemEntity3.desc = "吹爆！手残党随便抹涂就很好看就能出门系列，持久度也很好，一天下来闪片还将在，这么便宜还不买等什么！";
        itemEntity3.mall_price = "69.00";
        itemEntity3.current_price = "19.00";
        itemEntity3.deposit = "1.90";
        itemEntity3.days = "15";
        itemEntity3.image = R.mipmap.a1_4;

        AdmireItemEntity itemEntity4 = new AdmireItemEntity();
        itemEntity4.title = "MAC chili";
        itemEntity4.sell_points1 = "显白提气色";
        itemEntity4.sell_points2 = "复古哑光，色泽饱满";
        itemEntity4.sell_points3 = "复古哑光，色泽饱满";
        itemEntity4.desc = "如果只能选择一支口红，那么一定就是这支了！一度卖断货，砖红色，黄皮真爱！巨显白！雾面妆感是我的最爱了，很有质感，还不容易掉色！";
        itemEntity4.mall_price = "159.00";
        itemEntity4.current_price = "59.00";
        itemEntity4.deposit = "5.90";
        itemEntity4.days = "15";
        itemEntity4.image = R.mipmap.a1_3;

        AdmireItemEntity itemEntity5 = new AdmireItemEntity();
        itemEntity5.title = "gracebabi眉笔";
        itemEntity5.sell_points1 = "颜色百搭好上色";
        itemEntity5.sell_points2 = "雾面效果不脱妆";
        itemEntity5.sell_points3 = "跟单有返利，最高可返2%";
        itemEntity5.desc = "极细的笔头很好勾勒眉形，很细所以可以画出很自然的毛流感，顺滑好上色，上手又快又自然，眉刷稍微有点硬，但是很好晕染，重点是这个价格很让人惊喜！";
        itemEntity5.mall_price = "21.00";
        itemEntity5.current_price = "11.00";
        itemEntity5.deposit = "1.10";
        itemEntity5.days = "15";
        itemEntity5.image = R.mipmap.a1_5;

        itemEntities1.add(itemEntity1);
        itemEntities1.add(itemEntity2);
        itemEntities1.add(itemEntity3);
        itemEntities1.add(itemEntity4);
        itemEntities1.add(itemEntity5);
        entity1.products = itemEntities1;
        entity1.total_price = "298.00";
        entity1.total_deposit = "39.80";
        entity1.image = R.mipmap.aa_1;
        entity1.desc = "你离美妆博主就差这一套了！秋季开学美妆已全套准备好，性价比高，新手也合适，放心看下去吧！";
        entities.add(entity1);


        AdmireEntity entity2 = new AdmireEntity();
        entity2.setClickable(true);
        UserEntity userEntity2 = new UserEntity();
        userEntity2.nickname = "就是候洛洛";
        userEntity2.tags = new ArrayList<>();
        userEntity2.tags.add("洁癖星人");
        userEntity2.likes = "1484";
        userEntity2.image = R.mipmap.au_2;
        userEntity2.desc = "相逢恨晚！！生活必备神器！";
        entity2.user = userEntity2;
        List<AdmireItemEntity> itemEntities2 = new ArrayList<>();

        AdmireItemEntity itemEntity21 = new AdmireItemEntity();
        itemEntity21.title = "±深泽直人无线吸尘器";
        itemEntity21.sell_points1 = "低噪轻音，手持无线";
        itemEntity21.sell_points2 = "超长续航6小时";
        itemEntity21.sell_points3 = "跟单有返利，最高可返2%";
        itemEntity21.desc = "超喜欢的性冷淡风，安装也简单，最大的优点是特别特别轻！总共才1.3kg，妹子一只手就可以拎起来！吸头有点小，不过吸力很大，可以吸地毯、沙发和一些缝隙等等。充电一次可以用57分钟，非常持久，噪音还很小！";
        itemEntity21.mall_price = "1999.00";
        itemEntity21.current_price = "999.00";
        itemEntity21.deposit = "99.90";
        itemEntity21.days = "15";
        itemEntity21.image = R.mipmap.a2_1;

        AdmireItemEntity itemEntity22 = new AdmireItemEntity();
        itemEntity22.title = "小黄人便携榨汁机";
        itemEntity22.sell_points1 = "天生萌物，一眼爱上";
        itemEntity22.sell_points2 = "无需链接电源，方便轻巧";
        itemEntity22.sell_points3 = "跟单有返利，最高可返2%";
        itemEntity22.desc = "看到这个小黄人榨汁机我真的被萌到了，据说是限量版，不能错过！不用插电线，充好电后就双击小黄人眼睛就可以开始工作啦！榨汁时间是40秒一次，边摇边榨果汁会更加细腻哦，更神奇的是还能当充电宝！";
        itemEntity22.mall_price = "699.00";
        itemEntity22.current_price = "199.00";
        itemEntity22.deposit = "19.90";
        itemEntity22.days = "15";
        itemEntity22.image = R.mipmap.a2_2;

        AdmireItemEntity itemEntity23 = new AdmireItemEntity();
        itemEntity23.title = "友人洗菜机";
        itemEntity23.sell_points1 = "360度涡流喷淋，活氧双重除菌";
        itemEntity23.sell_points2 = "内置洗菜，外置洗肉，果蔬肉类分开洗";
        itemEntity23.sell_points3 = "跟单有返利，最高可返2%";
        itemEntity23.desc = "理念非常棒，解放双手，把食物洗的更干净，这两点深得我心。一直担心果蔬上的农药残留，但这个采用臭氧和等离子结合的方式，杀菌去农药残留率在99%左右，相当厉害！";
        itemEntity23.mall_price = "799.00";
        itemEntity23.current_price = "299.00";
        itemEntity23.deposit = "29.90";
        itemEntity23.days = "15";
        itemEntity23.image = R.mipmap.a2_3;

        itemEntities2.add(itemEntity21);
        itemEntities2.add(itemEntity22);
        itemEntities2.add(itemEntity23);
        entity2.products = itemEntities2;
        entity2.total_price = "1497.00";
        entity2.total_deposit = "149.70";
        entity2.image = R.mipmap.aa_2;
        entity2.desc = "强烈推荐几款相逢恨晚的生活必备神器！从此解放劳动力，秒速让生活幸福感飙升！";

        entities.add(entity2);


        AdmireEntity entity3 = new AdmireEntity();
        UserEntity userEntity3 = new UserEntity();
        userEntity3.nickname = "艾瑞小哥";
        userEntity3.tags = new ArrayList<>();
        userEntity3.tags.add("科技达人");
        userEntity3.likes = "3361";
        userEntity3.image = R.mipmap.au_3;
        userEntity3.desc = "网红博主们的数码黑科技大揭秘！";
        entity3.user = userEntity3;
        entity3.products = new ArrayList<>();
        entity3.products.add(new AdmireItemEntity(R.mipmap.a3_1));
        entity3.products.add(new AdmireItemEntity(R.mipmap.a3_2));
        entity3.products.add(new AdmireItemEntity(R.mipmap.a3_3));
        entity3.products.add(new AdmireItemEntity(R.mipmap.a3_4));
        entity3.total_price = "3685.00";
        entity3.total_deposit = "368.50";
        entity3.desc = "买了绝对不后悔系列之最值得入手的黑科技，包你从此告别无趣！";
        entities.add(entity3);


        AdmireEntity entity4 = new AdmireEntity();
        UserEntity userEntity4 = new UserEntity();
        userEntity4.nickname = "宝妈教主";
        userEntity4.tags = new ArrayList<>();
        userEntity4.tags.add("新手妈咪");
        userEntity4.likes = "3361";
        userEntity4.image = R.mipmap.au_4;
        userEntity4.desc = "超实用母婴好物推荐，不剁手，不踩雷！";
        entity4.user = userEntity4;
        entity4.products = new ArrayList<>();
        entity4.products.add(new AdmireItemEntity(R.mipmap.a4_1));
        entity4.products.add(new AdmireItemEntity(R.mipmap.a4_2));
        entity4.products.add(new AdmireItemEntity(R.mipmap.a4_3));
        entity4.total_price = "1703.00";
        entity4.total_deposit = "170.30";
        entity4.desc = "理智种草不踩雷！宝妈必备の超实用母婴好物大合集";
        entities.add(entity4);

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
        ProductEntity entity = new ProductEntity(R.mipmap.fresh1_1, "心相印茶语丝享小包餐巾纸便携式面巾纸巾包邮批发无香24包手帕纸", "19.90", "1.00");
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.fresh1_1);
        images.add(R.mipmap.fresh1_2);
        images.add(R.mipmap.fresh1_3);
        images.add(R.mipmap.fresh1_4);
        images.add(R.mipmap.fresh1_5);
        entity.setImages(images);
        List<String> tags = new ArrayList<>();
        tags.add("薰衣草");
        tags.add("自然清香");
        entity.setTags(tags);
        entity.setClickable(true);
        entity.setComment("质量很好,很便宜,物流快,材质不错,携带方便,气味不错,正品,外观不错,。超值的！包装是我喜欢的颜色。我非常喜欢绿色，大家可以看到我被罩也是绿色的，有种亲近大自然的感觉，舒心！");

        entity.days_tag = new ArrayList<>();
        entity.days_tag.add(new DaysEntity(7, "0.50"));
        entity.days_tag.add(new DaysEntity(30, "0.99"));

        entities.add(entity);

        ProductEntity entity1 = new ProductEntity(R.mipmap.fresh2_1, "佳洁士（Crest）全优7效抗牙菌斑 牙膏 40克（新老包装,随机发货）", "16.90", "1.00");
        List<Integer> images1 = new ArrayList<>();
        images1.add(R.mipmap.fresh2_1);
        images1.add(R.mipmap.fresh2_2);
        images1.add(R.mipmap.fresh2_3);
        images1.add(R.mipmap.fresh2_4);
        images1.add(R.mipmap.fresh2_5);
        images1.add(R.mipmap.fresh2_6);
        entity1.setImages(images1);
        List<String> tags1 = new ArrayList<>();
        tags1.add("祛牙渍健白");
        tags1.add("强健牙釉质");
        entity1.setTags(tags1);
        entity1.setClickable(true);
        entity1.setComment("旅游方便捷带，挺好的，物超所值，老品牌值得信赖，物流很快，用着效果还不错，下次还会光顾的");
        entities.add(entity1);

        entity.days_tag = new ArrayList<>();
        entity.days_tag.add(new DaysEntity(7, "0.50"));
        entity.days_tag.add(new DaysEntity(30, "0.99"));

        entities.add(new ProductEntity(R.mipmap.fresh3, "蓝月亮 洗衣液袋装深层洁净护理500g(自然清香)", "10.90", "1.00"));
        entities.add(new ProductEntity(R.mipmap.fresh4, "喜乐 菌优多乳酸菌饮品 牛奶发酵饮料原味330ml+30ml", "9.90", "1.00"));
        entities.add(new ProductEntity(R.mipmap.fresh5, "农心 NONG SHIM 香菇牛肉味 辛拉面 杯面 方便面泡面速食食品 65g 单杯", "5.90", "1.00"));
        entities.add(new ProductEntity(R.mipmap.fresh6, "美即MG 海洋冰泉水润清透面膜5片装（补水保湿 男女士面膜贴）", "15.00", "1.00"));
        return entities;
    }

    public static List<ProductEntity> getHotData() {
        List<ProductEntity> entities = new ArrayList<>();
        ProductEntity entity = new ProductEntity(R.mipmap.hot_main, "农夫山泉 17.5°橙 3kg装 铂金果 年货礼盒 新鲜水果", "89.90", "45.00");
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.hot1_1);
        images.add(R.mipmap.hot1_2);
        images.add(R.mipmap.hot1_3);
        images.add(R.mipmap.hot1_4);
        entity.setImages(images);
        List<String> tags = new ArrayList<>();
        tags.add("铂金果");
        tags.add("钻石果");
        entity.setTags(tags);
        entity.setClickable(true);
        entity.setComment("这橙子特别好吃，多汁多肉，甜度刚刚好，吃完有种橙子独有的香味留在口中。送了一箱给朋友，也是赞不绝口。也适合当礼盒。每箱还贴心地送了个挂线器，再也不用因为找不着刀具而要用指甲剥皮了。6斤装的一箱能有16个。配送也很给力，下了单隔天就送到。");
        entity.days_tag = new ArrayList<>();
        entity.days_tag.add(new DaysEntity(7, "7.94", 10.5f, 79.40f));
        entity.days_tag.add(new DaysEntity(15, "6.75", 22.40f, 67.50f));
        entity.days_tag.add(new DaysEntity(30, "4.50", 44.9f, 45.0f));
        entities.add(entity);


        ProductEntity entity1 = new ProductEntity(R.mipmap.hot2_main, "【享6期免息赠蓝牙音箱】Huawei/华为 Mate 20 全面屏珍珠屏超大广角徕卡三镜头mate20 x智能手机mate20x", "3999.00", "3499.00");
        List<Integer> images1 = new ArrayList<>();
        images1.add(R.mipmap.hot2_1);
        images1.add(R.mipmap.hot2_2);
        images1.add(R.mipmap.hot2_3);
        images1.add(R.mipmap.hot2_4);
        entity1.setImages(images1);
        List<String> tags1 = new ArrayList<>();
        tags1.add("翡冷翠");
        tags1.add("宝石蓝");
        entity1.setTags(tags1);
        entity1.setClickable(true);
        entity1.setComment("挺不错的，快递真叫一个快，快晚上买的，第二天一早就到了，深圳到北京估计飞来的。。。用起来速度还不错，玩游戏也不发烫，同一个游戏比我的xs温度低多了，给老爹买的，蓝色的也很漂亮！");
        entity1.days_tag = new ArrayList<>();
        entity1.days_tag.add(new DaysEntity(7, "396.01", 38.9f, 3960.1f));
        entity1.days_tag.add(new DaysEntity(15, "391.57", 83.30f, 3915.7f));
        entity1.days_tag.add(new DaysEntity(30, "383.23", 156.7f, 3832.3f));
        entity1.days_tag.add(new DaysEntity(60, "366.57", 333.3f, 3665.7f));
        entity1.days_tag.add(new DaysEntity(90, "349.90", 500f, 3499.0f));
        entity1.days_tag.add(new DaysEntity(180, "299.90", 1000f, 2999.0f));
        entities.add(entity1);

        entities.add(new ProductEntity(R.mipmap.hot3_main, "SK-IIsk2神仙水嫩肤清莹露skii洁面爽肤水护肤套装A", "2470.00", "1729.00"));
        entities.add(new ProductEntity(R.mipmap.hot4_main, "裕道府 五常稻花香 东北大米 10kg", "99.90", "54.90"));

        return entities;
    }
}
