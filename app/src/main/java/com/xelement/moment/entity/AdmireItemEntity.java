package com.xelement.moment.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oyty on 2019/1/17.
 */
public class AdmireItemEntity implements Parcelable {
    public String title;
    public String sell_points1;
    public String sell_points2;
    public String sell_points3;
    public String desc;
    public String current_price;
    public String mall_price;
    public String deposit;
    public String days;
    public int image;

    public AdmireItemEntity(int image) {
        this.image = image;
    }

    public AdmireItemEntity() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.sell_points1);
        dest.writeString(this.sell_points2);
        dest.writeString(this.sell_points3);
        dest.writeString(this.desc);
        dest.writeString(this.current_price);
        dest.writeString(this.mall_price);
        dest.writeString(this.deposit);
        dest.writeString(this.days);
        dest.writeInt(this.image);
    }

    protected AdmireItemEntity(Parcel in) {
        this.title = in.readString();
        this.sell_points1 = in.readString();
        this.sell_points2 = in.readString();
        this.sell_points3 = in.readString();
        this.desc = in.readString();
        this.current_price = in.readString();
        this.mall_price = in.readString();
        this.deposit = in.readString();
        this.days = in.readString();
        this.image = in.readInt();
    }

    public static final Parcelable.Creator<AdmireItemEntity> CREATOR = new Parcelable.Creator<AdmireItemEntity>() {
        @Override
        public AdmireItemEntity createFromParcel(Parcel source) {
            return new AdmireItemEntity(source);
        }

        @Override
        public AdmireItemEntity[] newArray(int size) {
            return new AdmireItemEntity[size];
        }
    };
}
