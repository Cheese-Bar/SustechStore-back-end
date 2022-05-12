package com.example.SustechStore.cachePool;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存池
 * @author Administrator
 */
public class CachePool {
    // 缓存池唯一实例
    private static CachePool instance;

    // 缓存Map
    private static Map<String, CacheItem> cacheItems;

    private CachePool() {
        cacheItems = new HashMap<String, CacheItem>();
    }

    /**
     * 获取唯一的实例
     * @return instance
     */
    public synchronized static CachePool getInstance() {
        if (instance == null) {
            instance = new CachePool();
        }

        return instance;
    }

    /**
     * 清除所有的Item缓存
     */
    public synchronized void clearAllItems() {
        cacheItems.clear();
    }

    /**
     * 清除过期的Item缓存
     */
    public synchronized void clearExpiredItems() {
        try {
            for (String key:cacheItems.keySet()) {
                if (cacheItems.get(key).isExpired())removeCacheItem(key);
            }
        }catch (Exception ignored){}

    }

    /**
     * 获取缓存实例
     * @param name 缓存名称
     * @return 缓存实例
     */
    public synchronized Integer getCacheItem(String name) {
        if (!cacheItems.containsKey(name)) {
            return null;
        }

        CacheItem cacheItem = (CacheItem) cacheItems.get(name);
        if (cacheItem.isExpired()) {
            return null;
        }

        return cacheItem.getEntity();
    }


    public synchronized void putCacheItem(String name, Integer i, long expires) {
        // 判断该对象是否在在缓存池，不在直接put
        if (!cacheItems.containsKey(name)) {
            cacheItems.put(name, new CacheItem(i, expires));
        }

        // 获取缓存池中对象，更新对象信息
        CacheItem cacheItem = (CacheItem) cacheItems.get(name);
        cacheItem.setCreateTime(new Date());
        cacheItem.setEntity(i);
        cacheItem.setExpireTime(expires);
    }

    /**
     * 移除缓存数据
     * @param name
     */
    public synchronized void removeCacheItem(String name) {
        if (!cacheItems.containsKey(name)) {
            return ;
        }
        cacheItems.remove(name);
    }

    /**
     * 获取缓存数据的数量
     * @return
     */
    public int getSize() {
        return cacheItems.size();
    }

}