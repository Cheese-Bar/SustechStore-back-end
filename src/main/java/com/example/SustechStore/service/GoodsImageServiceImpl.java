package com.example.SustechStore.service;

import com.example.SustechStore.mapper.GoodsImageMapper;
import com.example.SustechStore.pojo.GoodsImage;
import com.example.SustechStore.pojo.GoodsImageExample;
import com.example.SustechStore.pojo.GoodsImageKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsImageServiceImpl implements GoodsImageService {

    @Autowired
    private GoodsImageMapper goodsImageMapper;


    @Override
    public List<String> selectImage(int id) {
        GoodsImageExample goodsImageExample = new GoodsImageExample();
        GoodsImageExample.Criteria criteria = goodsImageExample.createCriteria();
        criteria.andGoodsIdEqualTo(id);

        List<GoodsImage> list = goodsImageMapper.selectByExample(goodsImageExample);
        List<String> images = new ArrayList<>();
        for (GoodsImageKey goodsImage : list) {
            images.add(goodsImage.getImageUrl());
        }
        return images;
    }

    @Override
    public String selectIcon(int id) {
        GoodsImageExample goodsImageExample = new GoodsImageExample();
        GoodsImageExample.Criteria criteria = goodsImageExample.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        criteria.andSequenceEqualTo((short) 1);
        List<GoodsImage> list = goodsImageMapper.selectByExample(goodsImageExample);
        if (list != null && list.size() > 0) {
            return list.get(0).getImageUrl();
        }
        return "";
    }
}
