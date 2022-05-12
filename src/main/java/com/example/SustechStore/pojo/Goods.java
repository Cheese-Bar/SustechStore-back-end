package com.example.SustechStore.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * null
 */
public class Goods implements Serializable {
    private Integer goodsId;

    private Integer sellerId;

    private String name;

    private Double price;

    private Date uploadTime;

    private String description;

    private Integer classificationId;

    private Integer addressId;

    private String addressDetail;

    private String tradeMethod;

    private Integer goodsState;

    private Integer type;

    private Integer addressId2;

    private String addressDetail2;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getTradeMethod() {
        return tradeMethod;
    }

    public void setTradeMethod(String tradeMethod) {
        this.tradeMethod = tradeMethod;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAddressId2() {
        return addressId2;
    }

    public void setAddressId2(Integer addressId2) {
        this.addressId2 = addressId2;
    }

    public String getAddressDetail2() {
        return addressDetail2;
    }

    public void setAddressDetail2(String addressDetail2) {
        this.addressDetail2 = addressDetail2;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Goods other = (Goods) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getClassificationId() == null ? other.getClassificationId() == null : this.getClassificationId().equals(other.getClassificationId()))
            && (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getAddressDetail() == null ? other.getAddressDetail() == null : this.getAddressDetail().equals(other.getAddressDetail()))
            && (this.getTradeMethod() == null ? other.getTradeMethod() == null : this.getTradeMethod().equals(other.getTradeMethod()))
            && (this.getGoodsState() == null ? other.getGoodsState() == null : this.getGoodsState().equals(other.getGoodsState()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAddressId2() == null ? other.getAddressId2() == null : this.getAddressId2().equals(other.getAddressId2()))
            && (this.getAddressDetail2() == null ? other.getAddressDetail2() == null : this.getAddressDetail2().equals(other.getAddressDetail2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getClassificationId() == null) ? 0 : getClassificationId().hashCode());
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getAddressDetail() == null) ? 0 : getAddressDetail().hashCode());
        result = prime * result + ((getTradeMethod() == null) ? 0 : getTradeMethod().hashCode());
        result = prime * result + ((getGoodsState() == null) ? 0 : getGoodsState().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAddressId2() == null) ? 0 : getAddressId2().hashCode());
        result = prime * result + ((getAddressDetail2() == null) ? 0 : getAddressDetail2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", description=").append(description);
        sb.append(", classificationId=").append(classificationId);
        sb.append(", addressId=").append(addressId);
        sb.append(", addressDetail=").append(addressDetail);
        sb.append(", tradeMethod=").append(tradeMethod);
        sb.append(", goodsState=").append(goodsState);
        sb.append(", type=").append(type);
        sb.append(", addressId2=").append(addressId2);
        sb.append(", addressDetail2=").append(addressDetail2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}