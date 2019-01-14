package com.xelement.moment.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * Created by oyty on 2018/8/31.
 */
public class AddressEntity implements Parcelable {

    public String address_detail;//	详细地址	string
    public String address_id;//	收货地址ID	number
    public String address_street;//	街道	string
    public String city;//	市	string
    public String city_code;//	市code	string
    public String district;//	区	string
    public String district_code;//	区code	string
    private int is_default;//	是否默认地址	number	0否, 1是
    public String mobile_num;//	手机号	string
    public String province;//	省	string
    public String province_code;//	省code	string
    public String street_code;//	街道code	string
    public String true_name;//	收货人姓名	string
    public String user_id;//	用户ID	number
    public boolean isOrderAddress = false;

    private boolean isChoosed;

    public boolean isDefault() {
        return is_default == 1;
    }

    public void setIsChoosed(boolean isChoosed) {
        this.isChoosed = isChoosed;
    }

    public boolean isChoosed() {
        return isChoosed;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj == this) {
            return true;
        } else if(!(obj instanceof AddressEntity)) {
            return false;
        } else {
            AddressEntity entity = (AddressEntity) obj;
            return entity.province.equals(province) &&
                    entity.city.equals(city) &&
                    entity.district.equals(district) &&
                    entity.mobile_num.equals(mobile_num) &&
                    entity.true_name.equals(true_name) &&
                    ((entity.address_street == null && address_street == null) || (entity.address_street != null && entity.address_street.equals(address_street))) &&
                    entity.address_detail.equals(address_detail);
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address_detail);
        dest.writeString(this.address_id);
        dest.writeString(this.address_street);
        dest.writeString(this.city);
        dest.writeString(this.city_code);
        dest.writeString(this.district);
        dest.writeString(this.district_code);
        dest.writeInt(this.is_default);
        dest.writeString(this.mobile_num);
        dest.writeString(this.province);
        dest.writeString(this.province_code);
        dest.writeString(this.street_code);
        dest.writeString(this.true_name);
        dest.writeString(this.user_id);
        dest.writeByte(this.isOrderAddress ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isChoosed ? (byte) 1 : (byte) 0);
    }

    public AddressEntity() {
    }

    protected AddressEntity(Parcel in) {
        this.address_detail = in.readString();
        this.address_id = in.readString();
        this.address_street = in.readString();
        this.city = in.readString();
        this.city_code = in.readString();
        this.district = in.readString();
        this.district_code = in.readString();
        this.is_default = in.readInt();
        this.mobile_num = in.readString();
        this.province = in.readString();
        this.province_code = in.readString();
        this.street_code = in.readString();
        this.true_name = in.readString();
        this.user_id = in.readString();
        this.isOrderAddress = in.readByte() != 0;
        this.isChoosed = in.readByte() != 0;
    }

    public static final Creator<AddressEntity> CREATOR = new Creator<AddressEntity>() {
        @Override
        public AddressEntity createFromParcel(Parcel source) {
            return new AddressEntity(source);
        }

        @Override
        public AddressEntity[] newArray(int size) {
            return new AddressEntity[size];
        }
    };
}
