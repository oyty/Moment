package com.xelement.moment.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oyty on 2019/1/14.
 */
public class ProductEntity implements Parcelable {

    public String currentPrice;
    public int image;
    public String title;
    public String receive_time;
    public String price;
    public List<Integer> images;
    public List<String> tags;
    public List<Integer> detail_images;
    private boolean clickable;
    public String comment;
    public List<DaysEntity> days_tag;

    public ProductEntity() {
    }

    public ProductEntity(int image, String title, String price) {
        this.image = image;
        this.title = title;
        this.price = price;
    }

    public ProductEntity(int image, String title, String price, String currentPrice) {
        this(image, title, price);
        this.currentPrice = currentPrice;
    }


    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public List<Integer> getImages() {
        return images;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.currentPrice);
        dest.writeInt(this.image);
        dest.writeString(this.title);
        dest.writeString(this.receive_time);
        dest.writeString(this.price);
        dest.writeList(this.images);
        dest.writeStringList(this.tags);
        dest.writeList(this.detail_images);
        dest.writeByte(this.clickable ? (byte) 1 : (byte) 0);
        dest.writeString(this.comment);
        dest.writeTypedList(this.days_tag);
    }

    protected ProductEntity(Parcel in) {
        this.currentPrice = in.readString();
        this.image = in.readInt();
        this.title = in.readString();
        this.receive_time = in.readString();
        this.price = in.readString();
        this.images = new ArrayList<Integer>();
        in.readList(this.images, Integer.class.getClassLoader());
        this.tags = in.createStringArrayList();
        this.detail_images = new ArrayList<Integer>();
        in.readList(this.detail_images, Integer.class.getClassLoader());
        this.clickable = in.readByte() != 0;
        this.comment = in.readString();
        this.days_tag = in.createTypedArrayList(DaysEntity.CREATOR);
    }

    public static final Creator<ProductEntity> CREATOR = new Creator<ProductEntity>() {
        @Override
        public ProductEntity createFromParcel(Parcel source) {
            return new ProductEntity(source);
        }

        @Override
        public ProductEntity[] newArray(int size) {
            return new ProductEntity[size];
        }
    };
}

