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
import com.xelement.moment.entity.NotificationEntity;
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
//            entities.add(new ProductEntity(4029961, "dostyle HS310 JBL制造商 滋润心窝立体声 金属耳机 入耳式耳机 音乐厅音律 荡漾红 胭脂扣 女神专属", "129", "50"));
//            entities.add(new ProductEntity(1814629, "三星（SAMSUNG）32GB USB3.0 U盘 BAR 银色 读速150MB/s 金属耐用，防水防震", "135", "58.5"));
//            entities.add(new ProductEntity(7494701, "索尼（SONY）SF-16UY3 16G SDHC UHS-I存储卡 90MB/S读取速度", "139", "69"));
//            entities.add(new ProductEntity(5256919, "纽曼 （Newmine） MX05 时尚复古木质无线便携蓝牙音箱立体声、重低音桌面音响 樱桃木色", "199", "89.1"));
//            entities.add(new ProductEntity(2532291, "暴风魔镜 4代IOS黄金版 虚拟现实智能VR眼镜3D头盔", "399", "199"));
//            entities.add(new ProductEntity(3095098, "豪恩智能家居套装 家用报警盒子家庭防盗报警器 豪恩二当家", "858", "298"));
//            entities.add(new ProductEntity(7950629, "M&D（Master & Dynamic）MH40 时尚复古头戴式音乐耳机  线控麦克风  滚石乐队版 炫酷黑", "2998", "999"));
//            entities.add(new ProductEntity(100000798810, "爱国者（aigo）P200充电宝厂家直送10000毫安充电宝 适用于小米 华为 苹果手机 白色", "199", "90"));
//            entities.add(new ProductEntity(4841525, "金胜（kingshare） 500GB Type-C 3.1移动固态硬盘（PSSD）S6冰河银轻巧便携手机电脑移动存储", "1299", "599"));
//            entities.add(new ProductEntity(5837586, "坚果（JmGO）1895 电影机 投影仪 投影机家用（1080P全高清 1200流明 复古机械操作）","9999","4999"));

            entities.add(new ProductEntity(R.mipmap.p1_1, "dostyle HS310 JBL制造商 滋润心窝立体声 金属耳机 入耳式耳机 音乐厅音律 荡漾红 胭脂扣 女神专属", "129", "50"));
            entities.add(new ProductEntity(R.mipmap.p1_2, "三星（SAMSUNG）32GB USB3.0 U盘 BAR 银色 读速150MB/s 金属耐用，防水防震", "135", "58.5"));
            entities.add(new ProductEntity(R.mipmap.p1_3, "索尼（SONY）SF-16UY3 16G SDHC UHS-I存储卡 90MB/S读取速度", "139", "69"));
            entities.add(new ProductEntity(R.mipmap.p1_4, "纽曼 （Newmine） MX05 时尚复古木质无线便携蓝牙音箱立体声、重低音桌面音响 樱桃木色", "199", "89.1"));
            entities.add(new ProductEntity(R.mipmap.p1_5, "暴风魔镜 4代IOS黄金版 虚拟现实智能VR眼镜3D头盔", "399", "199"));
            entities.add(new ProductEntity(R.mipmap.p1_6, "豪恩智能家居套装 家用报警盒子家庭防盗报警器 豪恩二当家", "858", "298"));
            entities.add(new ProductEntity(R.mipmap.p1_7, "M&D（Master & Dynamic）MH40 时尚复古头戴式音乐耳机  线控麦克风  滚石乐队版 炫酷黑", "2998", "999"));
            entities.add(new ProductEntity(R.mipmap.p1_8, "爱国者（aigo）P200充电宝厂家直送10000毫安充电宝 适用于小米 华为 苹果手机 白色", "199", "90"));
            entities.add(new ProductEntity(R.mipmap.p1_9, "金胜（kingshare） 500GB Type-C 3.1移动固态硬盘（PSSD）S6冰河银轻巧便携手机电脑移动存储", "1299", "599"));
            entities.add(new ProductEntity(R.mipmap.p1_10, "坚果（JmGO）1895 电影机 投影仪 投影机家用（1080P全高清 1200流明 复古机械操作）", "9999", "4999"));
        } else if (position == 2) {
            entities.add(new ProductEntity(R.mipmap.p2_1, "顽皮（Wanpy） Happy100 狗狗罐头 狗湿粮 泰迪贵宾雪纳瑞萨摩比熊柯基哈士奇鸡肉慕斯 狗罐头 95g*24罐", "116", "55.85"));
            entities.add(new ProductEntity(R.mipmap.p2_2, "蛙牌WA! 幼犬奶糕1KG 宝贝向前冲系列D1029 全犬种鲜肉制作狗粮 泰迪比熊贵宾博美", "78", "27.33"));
            entities.add(new ProductEntity(R.mipmap.p2_3, "麦富迪 狗粮牛肉双拼无谷粮通用成犬10kg", "460", "184.69"));
            entities.add(new ProductEntity(R.mipmap.p2_4, "比利时进口 不然呢(Primo)幼犬粮全能营养鸡肉甜薯味狗粮欧洲进口天然无谷主粮6KG-10602", "442", "212.4"));
            entities.add(new ProductEntity(R.mipmap.p2_5, "句句兽（JUJUKONG）松松饭 Flosssy Fun 生态海藻粉宠物零食 狗零食", "67", "29.37"));
            entities.add(new ProductEntity(R.mipmap.p2_6, "渔极 吞拿鱼及鲜虾猫罐头 泰国进口湿粮 宠物食品AkikA猫粮罐头AR13 70g*24罐", "329", "147.26"));
            entities.add(new ProductEntity(R.mipmap.p2_7, "顽皮Happy100猫猫咪罐头自营湿粮 猫咪猫零食成猫幼猫老龄猫老猫罐头鸡肉慕斯猫罐头95g*24罐", "114", "55.85"));
            entities.add(new ProductEntity(R.mipmap.p2_8, "蛙牌WA! 幼猫粮1.5KG 宝贝向前冲系列C2019 宠物主粮", "139", "46.34"));
            entities.add(new ProductEntity(R.mipmap.p2_9, "顽皮（Wanpy）宠物零食 猫零食 HAPPY100系列 肉干肉片 鳕鱼软片25g*12袋 整盒装", "79", "26.85"));
            entities.add(new ProductEntity(R.mipmap.p2_10, "pidan 孔雀翎逗猫棒 白色 逗猫玩具逗猫杆 羽毛碳纤维软杆", "119", "54.56"));
        } else if (position == 3) {
            entities.add(new ProductEntity(R.mipmap.p3_1, "初荷 TRUE HER 围巾女冬季羊毛加厚欧美秋季保暖围脖披肩两用年会团购礼盒包装 轻奢凝脂系列 红色", "339", "149"));
            entities.add(new ProductEntity(R.mipmap.p3_2, "卡宾Cabbeen 抽象印花上衣男士休闲圆领短袖T恤衫潮B 漂白色02 52/180/XL", "299", "80"));
            entities.add(new ProductEntity(R.mipmap.p3_3, "柒牌（SEVEN）牛仔夹克 男士青年长袖休闲宽松牛仔茄克外套 114K28070 深蓝 190", "615", "259"));
            entities.add(new ProductEntity(R.mipmap.p3_4, "百斯盾男装外套男 2018秋冬新款立领拼接短款中年商务男士毛呢大衣K53B1600601黑色165/88A", "399", "199"));
            entities.add(new ProductEntity(R.mipmap.p3_5, "皮尔卡丹（pierre cardin）321 牛仔裤男 微弹时尚休闲中腰男士裤子 浅蓝色36码", "399", "197.1"));
            entities.add(new ProductEntity(R.mipmap.p3_6, "PASS2018秋装简约字母印花白色长袖T恤女宽松学生网红衣服潮6830111220 漂白色 S", "179", "48"));
            entities.add(new ProductEntity(R.mipmap.p3_7, "一塘晨2018年秋季新款长袖翻领OL职业女装条纹衬衫 S81R0244CA5L 蓝色 L", "198.9", "69.9"));
            entities.add(new ProductEntity(R.mipmap.p3_8, "俞兆林 无袖吊带立体花雪纺连衣裙中长款挂脖露肩波西米亚渡假长裙 YWQZ182218花色M", "209", "99"));
            entities.add(new ProductEntity(R.mipmap.p3_9, "梦舒雅女裤黑色牛仔裤女韩版高腰2018秋新款翻边紧身九分裤J83500399 蓝色 28码/70B/2尺1", "399", "189"));
            entities.add(new ProductEntity(R.mipmap.p3_10, "雪中飞 冬款羽绒服女加厚中长貉子毛领保暖外套 A1621YY172 大红色XL", "899", "299"));
        } else if (position == 4) {
            entities.add(new ProductEntity(R.mipmap.p4_1, "海尔（Haier） BCD-225SECH-ES 225升 三门冰箱（白色）", "3599", "1763"));
            entities.add(new ProductEntity(R.mipmap.p4_2, "美的（Midea）电炖锅 电炖盅 煲汤锅  电砂锅 白瓷内胆 DZ08Easy101", "299", "99"));
            entities.add(new ProductEntity(R.mipmap.p4_3, "苏泊尔（SUPOR）电饭煲电饭锅4L容量 精铁球釜IH电磁加热CFXB40HC817-120", "1299", "587"));
            entities.add(new ProductEntity(R.mipmap.p4_4, "TCL 取暖器/暖风机/电暖器/电暖气/取暖器家用/取暖炉 浴霸 家用浴室壁挂式 TN-QG20-T5Q 银色", "239", "99"));
            entities.add(new ProductEntity(R.mipmap.p4_5, "创维（Skyworth）55E388G 55英寸4K超高清智能商用电视", "6999", "3200"));
            entities.add(new ProductEntity(R.mipmap.p4_6, "方太（FOTILE）一级能效 4.1KW大火力燃气灶 不锈钢灶（天然气） HT8GE", "2190", "850"));
            entities.add(new ProductEntity(R.mipmap.p4_7, "海尔（Haier）吸尘器 ZL601A 家用 立式 便携式 手持推杆", "259", "109"));
            entities.add(new ProductEntity(R.mipmap.p4_8, "西门子（SIEMENS）触控T型大吸力欧式吸油烟机燃气灶套装LC46AA95EW（不锈钢色）+ER7EA23JMP（天然气）", "7899", "3799"));
            entities.add(new ProductEntity(R.mipmap.p4_9, "飞利浦（PHILIPS）美容仪 SC6220/02 微晶美容仪器 紧致嫩肤焕肤仪", "1980", "990"));
            entities.add(new ProductEntity(R.mipmap.p4_10, "博朗（BRAUN）电动剃须刀全身水洗往复式刮胡刀德国进口三刀头3系320（红色）", "1099", "299"));
        } else if (position == 5) {
            entities.add(new ProductEntity(R.mipmap.p5_1, "好事达 折叠椅子 碳钢餐椅 棉麻坐面 绿色 绅达2614", "159", "95"));
            entities.add(new ProductEntity(R.mipmap.p5_2, "庆展 不锈钢厨房5件套炒铲子捞面勺子盛饭勺子汤勺子筷筒子 厨韵系列 K097-A", "79.9", "39.9"));
            entities.add(new ProductEntity(R.mipmap.p5_3, "佳佰 欧式 陶瓷碗 带盖 保鲜碗微波炉保鲜盒便当泡面碗 雅致3件套", "59", "33.1"));
            entities.add(new ProductEntity(R.mipmap.p5_4, "空间生活置物架厨房浴室五层架收纳架子55×30×158cm白色 WJM30135-5WH", "219", "94.05"));
            entities.add(new ProductEntity(R.mipmap.p5_5, "王麻子 小康人家菜刀 切片刀", "55", "27.6"));
            entities.add(new ProductEntity(R.mipmap.p5_6, "HMJIA 鞋柜 H-X3004W 三门鞋柜 简约翻版17cm超薄玄关鞋柜 门厅储物柜升级款暖白色", "359", "199"));
            entities.add(new ProductEntity(R.mipmap.p5_7, "Debo德铂柏格曼堡锅具套装304不锈钢汤锅奶锅二件套", "1298", "380"));
            entities.add(new ProductEntity(R.mipmap.p5_8, "派格（paiger）会议椅 电脑椅子 办公椅 家用休闲椅清新椅子ZSJ CH-042C", "799", "321"));
            entities.add(new ProductEntity(R.mipmap.p5_9, "溢彩年华 简易衣柜 淋膜防水布衣柜 90*45*160cm多功能卷帘布衣橱DKB5639", "149", "75.05"));
            entities.add(new ProductEntity(R.mipmap.p5_10, "慧乐家 家用梯 四步家用安全梯 折叠人字梯 红色 FNBJ-22117", "499", "245"));
        } else if (position == 6) {
            entities.add(new ProductEntity(R.mipmap.p6_1, "德国进口 德悠（HANSANU）德悠 200ml*24盒 全脂纯牛奶 整箱", "189", "59"));
            entities.add(new ProductEntity(R.mipmap.p6_2, "比利时进口 Noble贵族康比特花色夹心巧克力金禧听装 圣诞礼盒 糖果礼盒 休闲零食 400g", "413", "109"));
            entities.add(new ProductEntity(R.mipmap.p6_3, "福临门 东北大米 秋田小町 中粮出品 大米 5kg（新老包装交替）", "59.9", "34.9"));
            entities.add(new ProductEntity(R.mipmap.p6_4, "金龙鱼 食用油 非转基因 茶籽香型食用调和油5L", "118", "59.8"));
            entities.add(new ProductEntity(R.mipmap.p6_5, "八马茶业 茶叶 乌龙茶 安溪浓香型铁观音 私享浓情 252g", "147", "65"));
            entities.add(new ProductEntity(R.mipmap.p6_6, "七彩云南庆沣祥 茶叶 普洱茶 熟茶饼 陈香饼6年陈（黄字）礼盒装 357g", "580", "290"));
            entities.add(new ProductEntity(R.mipmap.p6_7, "三只松鼠零食大礼包休闲网红小吃送女友整箱批发混组合量贩装1095g", "180", "53.01"));
            entities.add(new ProductEntity(R.mipmap.p6_8, "德芙 Dove死心塌地巧克力礼盒 糖果巧克力 礼品 212g（德芙心印53g*4)", "229", "99.22"));
            entities.add(new ProductEntity(R.mipmap.p6_9, "蒙牛 甜小嗨 常温酸牛奶 200g*12 礼盒装", "69.9", "29.9"));
            entities.add(new ProductEntity(R.mipmap.p6_10, "法国原装进口荷兰乳牛全脂甜奶粉900克罐装", "108", "39.9"));
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

        List<Integer> detail_images = new ArrayList<>();
        detail_images.add(R.mipmap.fresh1_d1);
        detail_images.add(R.mipmap.fresh1_d2);
        detail_images.add(R.mipmap.fresh1_d3);
        detail_images.add(R.mipmap.fresh1_d4);
        detail_images.add(R.mipmap.fresh1_d5);
        detail_images.add(R.mipmap.fresh1_d6);
        detail_images.add(R.mipmap.fresh1_d7);
        detail_images.add(R.mipmap.fresh1_d8);
        detail_images.add(R.mipmap.fresh1_d9);
        entity.detail_images = detail_images;


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

        List<Integer> detail_images1 = new ArrayList<>();
        detail_images1.add(R.mipmap.fresh2_d1);
        detail_images1.add(R.mipmap.fresh2_d2);
        detail_images1.add(R.mipmap.fresh2_d4);
        detail_images1.add(R.mipmap.fresh2_d5);
        detail_images1.add(R.mipmap.fresh2_d6);
        detail_images1.add(R.mipmap.fresh2_d7);
        detail_images1.add(R.mipmap.fresh2_d8);
        detail_images1.add(R.mipmap.fresh2_d9);
        detail_images1.add(R.mipmap.fresh2_d10);
        detail_images1.add(R.mipmap.fresh2_d11);
        detail_images1.add(R.mipmap.fresh2_d12);
        entity1.detail_images = detail_images1;

        entity1.setComment("旅游方便捷带，挺好的，物超所值，老品牌值得信赖，物流很快，用着效果还不错，下次还会光顾的");
        entities.add(entity1);

        entity1.days_tag = new ArrayList<>();
        entity1.days_tag.add(new DaysEntity(7, "0.50"));
        entity1.days_tag.add(new DaysEntity(30, "0.99"));

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

        entity.detail_images = new ArrayList<>();
        entity.detail_images.add(R.mipmap.hot1_d1);
        entity.detail_images.add(R.mipmap.hot1_d2);
        entity.detail_images.add(R.mipmap.hot1_d3);
        entity.detail_images.add(R.mipmap.hot1_d4);
        entity.detail_images.add(R.mipmap.hot1_d5);
        entity.detail_images.add(R.mipmap.hot1_d6);
        entity.detail_images.add(R.mipmap.hot1_d7);
        entity.detail_images.add(R.mipmap.hot1_d8);
        entity.detail_images.add(R.mipmap.hot1_d9);
        entity.detail_images.add(R.mipmap.hot1_d10);
        entity.detail_images.add(R.mipmap.hot1_d11);
        entity.detail_images.add(R.mipmap.hot1_d12);
        entity.detail_images.add(R.mipmap.hot1_d13);
        entity.detail_images.add(R.mipmap.hot1_d14);
        entity.detail_images.add(R.mipmap.hot1_d15);
        entity.detail_images.add(R.mipmap.hot1_d16);
        entity.detail_images.add(R.mipmap.hot1_d17);

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

        entity1.detail_images = new ArrayList<>();
        entity1.detail_images.add(R.mipmap.hot2_d1);
        entity1.detail_images.add(R.mipmap.hot2_d2);
        entity1.detail_images.add(R.mipmap.hot2_d3);
        entity1.detail_images.add(R.mipmap.hot2_d4);
        entity1.detail_images.add(R.mipmap.hot2_d5);
        entity1.detail_images.add(R.mipmap.hot2_d6);
        entity1.detail_images.add(R.mipmap.hot2_d7);
        entity1.detail_images.add(R.mipmap.hot2_d8);
        entity1.detail_images.add(R.mipmap.hot2_d9);

        entities.add(entity1);

        entities.add(new ProductEntity(R.mipmap.hot3_main, "SK-IIsk2神仙水嫩肤清莹露skii洁面爽肤水护肤套装A", "2470.00", "1729.00"));
        entities.add(new ProductEntity(R.mipmap.hot4_main, "裕道府 五常稻花香 东北大米 10kg", "99.90", "54.90"));

        return entities;
    }

    public static List<NotificationEntity> getNotificationData() {
        List<NotificationEntity> entities = new ArrayList<>();
        entities.add(new NotificationEntity(R.mipmap.au_1, "庄周", "1", "舒肤佳沐浴露"));
        entities.add(new NotificationEntity(R.mipmap.au_2, "后羿", "1", "蓝月亮洗衣液"));
        entities.add(new NotificationEntity(R.mipmap.au_3, "小乔", "20", "一箱橙子"));
        return entities;
    }
}
