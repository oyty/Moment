package com.xelement.moment.entity;

/**
 * Created by oyty on 2019/1/18.
 */
public class NotificationEntity {
    public String product;
    public int image;
    public String name;
    public String price;

    public NotificationEntity(int image, String name, String price, String product) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.product = product;
    }
}
