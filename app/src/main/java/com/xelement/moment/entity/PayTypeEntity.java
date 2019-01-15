package com.xelement.moment.entity;

/**
 * Created by oyty on 2018/9/7.
 */
public class PayTypeEntity {

    public String limit;//	充值最低支付限额	number
    public String limit_desc;//	充值最低支付限额描述	string
    public String limit_high;//	充值最高支付限额	number	为空或者为0则表示无限制
    public String limit_high_desc;//	充值最高限额描述	string
    public String limit_high_hc;//	订单支付最高支付限额	number	为空或者为0则表示无限制
    public String limit_high_hc_desc;//	订单支付最高支付限额描述	string
    public String limit_low_hc;//	订单支付最低支付限额	number
    public String limit_low_hc_desc;//	订单支付最低支付限额描述	string
    public String name;//	支付渠道名称	string
    public int pay_channel;//	支付渠道编号	number	1微信，2支付宝
    public int pay_platform;//	支付代理平台	number	1：ping++
    public String remark;//	描述	string
    private boolean isChoosed;

    public boolean isWechat() {
        return pay_channel == 1;
    }

    public boolean isAlipay() {
        return pay_channel == 2;
    }

    public boolean isJD() {
        return pay_channel == 3;
    }

    public void setChoosed(boolean isChoosed) {
        this.isChoosed = isChoosed;
    }

    public boolean isChoosed() {
        return isChoosed;
    }
}
