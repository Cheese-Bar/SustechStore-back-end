package com.example.SustechStore.cachePool;



import java.util.Date;

/**
 * 缓存实体
 */
public class CacheItem {

    // 创建缓存时间
    private Date createTime = new Date();

    // 缓存期满时间
    private long expireTime = 0;

    // 缓存实体
    private Integer entity;

    public CacheItem(Integer obj, long expires) {
        this.entity = obj;
        this.expireTime = expires;
    }

    // 判断缓存是否超时
    public boolean isExpired() {
        return (expireTime != -1 && new Date().getTime() - createTime.getTime() > expireTime);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}