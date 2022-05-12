package com.example.SustechStore.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class GoodBrief {
    private int goodId;
    private String goodName;
    private double goodPrice;
    private Timestamp uploadTime;

    private String goodIcon;

    private int sellerId;
    private String sellerName;
    private int sellerCredit;

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }
    public String getGoodIcon() {
        return goodIcon;
    }

    public void setGoodIcon(String goodIcon) {
        this.goodIcon = goodIcon;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getSellerCredit() {
        return sellerCredit;
    }

    public void setSellerCredit(int sellerCredit) {
        this.sellerCredit = sellerCredit;
    }

}
