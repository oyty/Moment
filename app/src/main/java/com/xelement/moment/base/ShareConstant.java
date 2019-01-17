package com.xelement.moment.base;

import android.text.TextUtils;


import com.xelement.moment.R;

import java.util.EnumSet;

/**
 * Created by cj_zuo on 2017/6/8.
 */

public class ShareConstant {

    public enum SharePlatform {
        WEI_CHAT(R.drawable.weixin_login, "微信", "1"), MOMENT(R.drawable.wechat_moment, "朋友圈", "2"),
        QQ(R.drawable.qq_login, "QQ好友", "3"), QZONG(R.drawable.qzong, "QQ空间", "4"),
        WEI_BO(R.drawable.weibo, "新浪微博", "5");

        public int iconId;
        public String name;
        public String shareType; //分享渠道 1:微信好友, 2:微信朋友圈, 3:QQ好友, 4:QQ空间, 5:微博

        SharePlatform(int iconId, String name, String shareType) {
            this.iconId = iconId;
            this.name = name;
            this.shareType = shareType;
        }

        public static SharePlatform getShareTypeByType(String type) {
            for (SharePlatform platform : SharePlatform.values()) {
                if (TextUtils.equals(type, platform.shareType)) {
                    return platform;
                }
            }
            return null;
        }
    }

    public enum AuthType {
        //MOBILE("1"),
        WECHAT("2"), QQ("3"), SINA("4");

        public String value;

        AuthType(String value) {
            this.value = value;
        }
    }

    public enum OrderType {
        //分享类型 1:应用分享, 2:商品分享
        App_Share("1"), PRODUCT_SHARE("2");

        public String type;

        OrderType(String type) {
            this.type = type;
        }
    }

    public enum ShareType {
        //分享类型 1:链接, 2:图片分享, 3:小程序分享
        LINK_Share, IMG_SHARE, MIN_APP;
    }

    public enum AwardType {
        Credit("1", "积分"), VoucherBids("2", "赠币"), RealBids("3", "拍币"), BuyBids("4", "购物币");

        public String value;
        public String descStr;

        AwardType(String value, String descStr) {
            this.value = value;
            this.descStr = descStr;
        }

        public static AwardType getAwardType(String value) {
            for (AwardType type : EnumSet.allOf(AwardType.class)) {
                if (TextUtils.equals(type.value, value)) {
                    return type;
                }
            }
            return null;
        }
    }
}
