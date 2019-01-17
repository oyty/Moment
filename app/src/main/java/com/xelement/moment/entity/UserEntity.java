package com.xelement.moment.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by oyty on 2019/1/17.
 */
public class UserEntity implements Parcelable {
    public String nickname;
    public List<String> tags;
    public String desc;
    public String likes;
    public int image;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nickname);
        dest.writeStringList(this.tags);
        dest.writeString(this.desc);
        dest.writeString(this.likes);
        dest.writeInt(this.image);
    }

    public UserEntity() {
    }

    protected UserEntity(Parcel in) {
        this.nickname = in.readString();
        this.tags = in.createStringArrayList();
        this.desc = in.readString();
        this.likes = in.readString();
        this.image = in.readInt();
    }

    public static final Parcelable.Creator<UserEntity> CREATOR = new Parcelable.Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel source) {
            return new UserEntity(source);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };
}
