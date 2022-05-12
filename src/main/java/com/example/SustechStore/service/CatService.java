package com.example.SustechStore.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


public interface CatService {
    List<Map<String,Object>> findCatPageDetail(String cat, Timestamp timestamp, int pageNum, int pageSize,int type);
    List<Map<String,Object>> init(int type);
}
