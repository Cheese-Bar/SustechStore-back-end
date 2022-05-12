package com.example.SustechStore.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Map<String, Object>> selectBySellerId(int id, int pageNum, int pageSize,
                                               Timestamp timestamp, int type,
                                               int orderNum, int goodState);
    List<Map<String, Object>> selectByBuyerId(int id, int pageNum, int pageSize,
                                              Timestamp timestamp, int type,
                                              int orderNum, int goodState);
    Map<String, Object> buyGood(int userId, int goodId);
}
