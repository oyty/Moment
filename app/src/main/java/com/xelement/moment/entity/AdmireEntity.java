package com.xelement.moment.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oyty on 2019/1/12.
 */
public class AdmireEntity implements Parcelable {

    public UserEntity user;
    public List<AdmireItemEntity> products;

    public String total_deposit;
    public String total_price;
    public int image;
    public String desc;
    private boolean clickable;
    private boolean isChecked;

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setChecked(boolean check) {
        this.isChecked = check;
    }

    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
        dest.writeTypedList(this.products);
        dest.writeString(this.total_deposit);
        dest.writeString(this.total_price);
        dest.writeInt(this.image);
        dest.writeString(this.desc);
        dest.writeByte(this.clickable ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
    }

    public AdmireEntity() {
    }

    protected AdmireEntity(Parcel in) {
        this.user = in.readParcelable(UserEntity.class.getClassLoader());
        this.products = in.createTypedArrayList(AdmireItemEntity.CREATOR);
        this.total_deposit = in.readString();
        this.total_price = in.readString();
        this.image = in.readInt();
        this.desc = in.readString();
        this.clickable = in.readByte() != 0;
        this.isChecked = in.readByte() != 0;
    }

    public static final Creator<AdmireEntity> CREATOR = new Creator<AdmireEntity>() {
        @Override
        public AdmireEntity createFromParcel(Parcel source) {
            return new AdmireEntity(source);
        }

        @Override
        public AdmireEntity[] newArray(int size) {
            return new AdmireEntity[size];
        }
    };
}
