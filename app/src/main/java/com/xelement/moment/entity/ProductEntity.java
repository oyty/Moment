package com.xelement.moment.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oyty on 2019/1/14.
 */
public class ProductEntity implements Parcelable {

    public int image;
    public String title;
    public String receive_time;
    public String price;
    public List<Integer> images;
    public List<String> tags;

    public ProductEntity() {
    }

    public ProductEntity(int image, String title, String price) {
        this.image = image;
        this.title = title;
        this.price = price;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeString(this.title);
        dest.writeString(this.receive_time);
        dest.writeString(this.price);
        dest.writeList(this.images);
        dest.writeStringList(this.tags);
    }

    protected ProductEntity(Parcel in) {
        this.image = in.readInt();
        this.title = in.readString();
        this.receive_time = in.readString();
        this.price = in.readString();
        this.images = new ArrayList<Integer>();
        in.readList(this.images, Integer.class.getClassLoader());
        this.tags = in.createStringArrayList();
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

    public List<String> getTags() {
        return tags;
    }
}
