package com.xelement.moment.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.xelement.moment.util.DateTimeUtil;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by oyty on 2019/1/15.
 */
public class OrderEntity implements Parcelable {
    public int status; // 1 待收货  0 待支付尾款
    public int image;
    public String title;
    public String price;
    public String current_price;
    public String sku;
    public String tag1;
    public String tag2;
    public String deposit_after;
    public String time;
    public String deposit;
    public String days;
    public String count;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.status);
        dest.writeInt(this.image);
        dest.writeString(this.title);
        dest.writeString(this.price);
        dest.writeString(this.current_price);
        dest.writeString(this.sku);
        dest.writeString(this.tag1);
        dest.writeString(this.tag2);
        dest.writeString(this.deposit_after);
        dest.writeString(this.time);
        dest.writeString(this.deposit);
        dest.writeString(this.days);
        dest.writeString(this.count);
    }

    public OrderEntity() {
    }

    protected OrderEntity(Parcel in) {
        this.status = in.readInt();
        this.image = in.readInt();
        this.title = in.readString();
        this.price = in.readString();
        this.current_price = in.readString();
        this.sku = in.readString();
        this.tag1 = in.readString();
        this.tag2 = in.readString();
        this.deposit_after = in.readString();
        this.time = in.readString();
        this.deposit = in.readString();
        this.days = in.readString();
        this.count = in.readString();
    }

    public static final Creator<OrderEntity> CREATOR = new Creator<OrderEntity>() {
        @Override
        public OrderEntity createFromParcel(Parcel source) {
            return new OrderEntity(source);
        }

        @Override
        public OrderEntity[] newArray(int size) {
            return new OrderEntity[size];
        }
    };

    public Date getDate() {
        return addDate(DateTimeUtil.parseDate(time), Long.parseLong(days));
    }

    public static Date addDate(Date date, long day) {
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
        time += day; // 相加得到新的毫秒数
        return new Date(time); // 将毫秒数转换成日期
    }

}

