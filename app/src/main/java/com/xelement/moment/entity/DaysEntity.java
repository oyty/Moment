package com.xelement.moment.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oyty on 2019/1/18.
 */
public class DaysEntity implements Parcelable {

    public int day;
    public float benifit;
    public String deposit;
    public float current_price;

    public DaysEntity(int day, String deposit, float benifit, float current_price) {
        this.day = day;
        this.deposit = deposit;
        this.benifit = benifit;
        this.current_price = current_price;
    }

    public DaysEntity(int day, String deposit) {
        this.day = day;
        this.deposit = deposit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.day);
        dest.writeFloat(this.benifit);
        dest.writeString(this.deposit);
        dest.writeFloat(this.current_price);
    }

    protected DaysEntity(Parcel in) {
        this.day = in.readInt();
        this.benifit = in.readFloat();
        this.deposit = in.readString();
        this.current_price = in.readFloat();
    }

    public static final Parcelable.Creator<DaysEntity> CREATOR = new Parcelable.Creator<DaysEntity>() {
        @Override
        public DaysEntity createFromParcel(Parcel source) {
            return new DaysEntity(source);
        }

        @Override
        public DaysEntity[] newArray(int size) {
            return new DaysEntity[size];
        }
    };
}
