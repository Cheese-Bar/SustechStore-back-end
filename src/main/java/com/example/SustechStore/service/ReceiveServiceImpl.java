package com.example.SustechStore.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.SustechStore.mapper.*;
import com.example.SustechStore.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReceiveServiceImpl implements ReceiveService {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    ClassificationMapper classificationMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    GoodsLabelsMapper goodsLabelsMapper;
    @Autowired
    LabelsMapper labelsMapper;
    @Autowired
    GoodsImageMapper goodsImageMapper;


    @Override
    public boolean addGoodDetail(JSONObject jsonObject) {
        System.out.println(jsonObject.toJSONString());
        int goodId = jsonObject.getInteger("goodId");
        int userId = jsonObject.getInteger("userId");
        int type = jsonObject.getInteger("type");
        String goodName = jsonObject.getString("goodName");
        double price = jsonObject.getDouble("goodPrice") == null ? 0 : jsonObject.getDouble("goodPrice");
        int classificationId = getClassificationId(jsonObject.getString("classification"));
        int addressId = getAddressId(jsonObject.getString("addressId"));
        String addressDetail = jsonObject.getString("addressDetail");

        int addressId2 = getAddressId(jsonObject.getString("addressId2"));
        String addressDetail2 = jsonObject.getString("addressDetail2");

        String tradeMethod = jsonObject.getString("tradeMethod");
        String description = jsonObject.getString("description");
        JSONArray labelList = jsonObject.getJSONArray("labels");
        JSONArray imageList = jsonObject.getJSONArray("images");

        Users users = new Users();
        users.setUserId(userId);
        int new_credit = usersMapper.selectByPrimaryKey(userId).getCreditScore() - 2;
        users.setCreditScore(Math.max(new_credit, 0));
        usersMapper.updateByPrimaryKeySelective(users);

        if (existUser(userId)) {
            Goods goods = new Goods();
            goods.setGoodsId(goodId != -1 ? goodId : null);
            goods.setSellerId(userId);
            goods.setType(type);
            goods.setName(goodName);
            goods.setPrice(price);
            goods.setClassificationId(classificationId == -1 ? null : classificationId);
            goods.setAddressId(addressId == -1? null: addressId);
            goods.setAddressDetail(addressDetail);
            goods.setAddressId2(addressId2 == -1 ? null: addressId2);
            goods.setAddressDetail2(addressDetail2);
            goods.setTradeMethod(tradeMethod);
            goods.setUploadTime(new Date(System.currentTimeMillis()));
            goods.setGoodsState(1);
            goods.setDescription(description);

            // 判断标签合法？（还没加）
            if (goodId == -1) {
                goodsMapper.insertSelective(goods);
                int goodIdTemp = goods.getGoodsId();
                insertGoodToLabels(goodIdTemp, labelList);
                insertGoodsImage(goodIdTemp, imageList);
            } else {
                goodsMapper.updateByPrimaryKey(goods);
                // 删除原有的 label指向
                GoodsLabelsExample goodsLabelsExample = new GoodsLabelsExample();
                GoodsLabelsExample.Criteria criteria1 = goodsLabelsExample.createCriteria();
                criteria1.andGoodsIdEqualTo(goods.getGoodsId());
                goodsLabelsMapper.deleteByExample(goodsLabelsExample);
                // 删除原有的 url指向
                GoodsImageExample goodsImageExample = new GoodsImageExample();
                GoodsImageExample.Criteria criteria2 = goodsImageExample.createCriteria();
                criteria2.andGoodsIdEqualTo(goods.getGoodsId());
                goodsImageMapper.deleteByExample(goodsImageExample);
                // 添加新的url和label
                int goodIdTemp = goods.getGoodsId();
                insertGoodToLabels(goodIdTemp, labelList);
                insertGoodsImage(goodIdTemp, imageList);
            }
            return true;
        }
        return false;
    }

    public boolean insertGoodToLabels(int goodId, JSONArray labelList) {
        if (labelList == null) {
            return false;
        }
        Object[] list = labelList.toArray();
        for (Object o : list) {
            GoodsLabelsKey goodsLabelsKey = new GoodsLabelsKey();
            goodsLabelsKey.setGoodsId(goodId);
            goodsLabelsKey.setLabelsId(getLabelId((String) o));
            goodsLabelsMapper.insert(goodsLabelsKey);
        }
        return true;
    }

    public boolean existUser(int userId) {
        return usersMapper.selectByPrimaryKey(userId) != null;
    }

    public int getClassificationId(String classification) {
        if (classification == null) {
            return -1;
        }
        ClassificationExample classificationExample = new ClassificationExample();
        ClassificationExample.Criteria criteria = classificationExample.createCriteria();
        criteria.andClassificationNameEqualTo(classification);
        List<Classification> classification1 = classificationMapper.selectByExample(classificationExample);
        if (!classification1.isEmpty()) {
            return classification1.get(0).getClassificationId();
        } else {
            return -1;
        }
    }

    public int getAddressId(String s) {
        if (s == null){
            return -1;
        }
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andAddressNameEqualTo(s);
        List<Address> list = addressMapper.selectByExample(addressExample);
        if (!list.isEmpty()) {
            return list.get(0).getAddressId();
        }
        return -1;
    }

    public int getLabelId(String s) {
        LabelsExample labelsExample = new LabelsExample();
        LabelsExample.Criteria criteria = labelsExample.createCriteria();
        criteria.andLabelsNameEqualTo(s);
        List<Labels> list = labelsMapper.selectByExample(labelsExample);
        if (!list.isEmpty()) {
            return list.get(0).getLabelsId();
        }
        return -1;
    }

    public boolean insertGoodsImage(int goodId, JSONArray imageList) {
        if (imageList == null) {
            return false;
        }
        Object[] list = imageList.toArray();
        short cnt = 1;
        for (Object o : list) {
            GoodsImage goodsImage = new GoodsImage();
            goodsImage.setGoodsId(goodId);
            goodsImage.setImageUrl((String) o);
            goodsImage.setSequence(cnt++);
            goodsImageMapper.insert(goodsImage);
        }
        return true;
    }

    public List<Address> getAllAddress() {
        return addressMapper.selectAll();
    }

    public List<Labels> getAllLabels() {
        return labelsMapper.selectAll();
    }
}
