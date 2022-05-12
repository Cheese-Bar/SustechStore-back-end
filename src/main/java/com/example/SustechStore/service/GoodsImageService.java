package com.example.SustechStore.service;

import java.util.List;

public interface GoodsImageService {
    List<String> selectImage(int id);
    String selectIcon(int id);
}
