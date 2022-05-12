package com.example.SustechStore.service;

import com.alibaba.fastjson.JSONObject;
import com.example.SustechStore.pojo.Address;
import com.example.SustechStore.pojo.Labels;

import java.util.List;

public interface ReceiveService {
    public boolean addGoodDetail(JSONObject jsonObject);

    public List<Address> getAllAddress();

    public List<Labels> getAllLabels();
}
